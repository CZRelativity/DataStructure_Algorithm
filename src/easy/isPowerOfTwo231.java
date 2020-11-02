package easy;

public class isPowerOfTwo231 {
    public static void main(String[] args){
        isPowerOfTwo231 t=new isPowerOfTwo231();
        t.test();
    }

    private void test(){
        int[] eg=new int[]{-1,0,1,16,218,Integer.MIN_VALUE};
        for(int e:eg){
            System.out.println(isPowerOfTwo(e));
        }
    }

    public boolean isPowerOfTwo(int n) {
        /* 暴力解决边界条件了- -
        * Integer.MIN_VALUE的时候只有符号位，即最高位第32位是1
        * 不过确实，这里说的是整数次幂，那就不可能是负数的 */
        return n>0&&Integer.bitCount(n)==1;
    }
}
