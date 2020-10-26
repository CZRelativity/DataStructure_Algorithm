package easy;

public class trailingZeros172 {
    public static void main(String[] args) {
        trailingZeros172 t = new trailingZeros172();
        int res = t.trailingZeroes(30);
        System.out.println(res);
    }

    public int trailingZeroes(int n) {
        /* 末尾0的来源只有2*5，因数中能分几个5出来就有多少个0，2绝对比5多每个偶数都能分出来，所以不用考虑了
        * 要考虑的就是25里有两个5，125里有三个5，以此类推 */
        int zeros = 0;
        int fives = 5;
        while (n >= fives) {
            zeros += n / fives;
            fives*=5;
        }
        return zeros;
    }
}
