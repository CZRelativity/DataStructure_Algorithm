package middle;

public class multiStr43 {
    public static void main(String[] args) {
        multiStr43 t = new multiStr43();
        String[] eg1 = new String[]{"2", "3"};
        String[] eg2 = new String[]{"123", "456"};
        String[] eg4=new String[]{"999","999"};
        String[] eg3 = new String[]{"123456789", "987654321"};
        String result = t.solveOriginal(eg3[1], eg3[0]);
        System.out.println(result);
    }

    //时间90%
    public String solveOriginal(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();

        int length = l1 + l2-1;
        /*product 乘积，拿一个数组来存储每个位相乘的结果，
        一个三位数和一个三位数相乘最大也只能得到一个六位数，不可能得到七位数
        而且第6位也一定是从第5位进上去的，我只是要最高位的Str，可以直接把二位数转来输出
        就用不着把最高位进位了
        * */
        int[] product = new int[length];
        int curProduct;
        //不在加法循环里面进位，反而可以避免后面再加的时候没有进到
        for (int i1 = 0; i1 < l1; i1++) {
            for (int i2 = 0; i2 < l2; i2++) {
                curProduct = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                product[length - 1 - i1 - i2] += curProduct;
            }
        }
        //加完了从低到高一起进位，不会出错
        for (int i = 0; i < length - 1; i++) {
            if (product[i] >= 10) {
                curProduct = product[i];
                product[i + 1] += curProduct / 10;
                product[i] = curProduct % 10;
            }
        }

        //因为积的数组按最大的size来创建的怕溢出，本来以为是要去掉前面可能无效的0
        //但是其实我最高位可以直接不进位直接把两位数转String是一样的，那就用不着了

        StringBuilder productStr = new StringBuilder();

        for(int j=length-1;j>-1;j--){
            productStr.append(product[j]);
        }
        return productStr.toString();
    }
}
