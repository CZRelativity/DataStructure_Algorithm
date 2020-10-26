package middle;

public class twoDivide29 {
    public static void main(String[] args) {
        twoDivide29 t = new twoDivide29();
        int[] eg1 = new int[]{Integer.MIN_VALUE, -3};
        int[] eg2 = new int[]{Integer.MAX_VALUE, 1};
        int[] eg3 = new int[]{Integer.MIN_VALUE, -1};
        int[] eg4 = new int[]{1, 1};
        int[] eg5 = new int[]{0, 1};
        int[] eg6 = new int[]{7, -3};

        int result = t.solveBinary(eg6[0], eg6[1]);
        System.out.println(result);
    }

    //发现全部转成负数的话可以避免溢出，但不用二分法绝对会超时淦
//    public int solveOriginal(int dividend,int divisor){
//        int result=0;
//        long sum=0;
//
//        if(divisor==1){
//            return dividend;
//        }
//
//        if(divisor==-1){
//            return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
//        }
//
//        int negDividend=dividend<0?dividend:-dividend;
//        int negDivisor=divisor<0?divisor:-divisor;
//
//        while(sum>negDividend){
//            sum+=negDivisor;
//            result++;
//        }
//
//        if(sum<negDividend){
//            result--;
//        }
//
//        return (dividend>0&&divisor<0)||(dividend<0&&divisor>0)?
//                -result:result;
//    }

    public int solveBinary(int dividend, int divisor) {
        //先排除所有特殊情况，这道题的难点就在好多溢出的陷阱
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        //除以-1要考虑溢出
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        //除以最大绝对值也算特殊情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        //一个技巧是全部转负可以排除被除数为Integer.MIN_VALUE时转正溢出的问题
        int negDividend = dividend < 0 ? dividend : -dividend;
        int negDivisor = divisor < 0 ? divisor : -divisor;

        /*实际上在这道题中以上已经排除了所有可能溢出的情况（？）下面可以直接用int存放结果
        * 其实这里只需要存放递归的结果*/
        int res = binaryDivide(negDividend, negDivisor);

        //由于前面转到同号方便运算，这里要根据符号还原结果
        return (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ?
                -res : res;
    }


    public int binaryDivide(int negDividend, int negDivisor) {
        //递归的结束条件是被除数不够除了
        if (negDivisor < negDividend) {
            return 0;
        }
        int res = 1;
        int sum = negDivisor;
        /*二分思想，倍增迭代逼近除数，如果下一次翻倍会超过除数，就在这时结束迭代
         * 尴尬的是如果使用negDividend<=sum+sum,这个两倍的sum会溢出导致无法退出循环
         * 结果完美的还是下面的形式*/
        while (negDividend - sum <= sum) {
            sum += sum;
            res += res;
        }
        //递归，把剩下还没有除完的部分继续拿去除，并且把剩下部分得到的结果也加上
        res += binaryDivide(negDividend - sum, negDivisor);
        return res;
    }
}
