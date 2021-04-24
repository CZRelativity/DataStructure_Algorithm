package middle;

public class integerBreak343 {
    public static void main(String[] args) {
        integerBreak343 t = new integerBreak343();
        t.test();
    }

    private void test() {
        int[] eg = {4, 3, 8, 2, 10,};
        for (int e : eg) {
            System.out.println(integerBreakMath(e));
        }
    }

    //100%，但是多次submit改出来的方法，但是感觉边界有点多，不是很好
    public int integerBreak(int n) {
        int sum = Integer.MIN_VALUE;
        int curSum, curN;
        /* 由于8=3+3+2这种情况，不像之前想的一样的一样是能几等分，而是要从2等分开始--
         * 同时考虑到3=1+2这种情况，二等分也要向上取整 */
        for (int factor = (int) ((double) n / 2); factor > 0; factor--) {
            curN = n;
            curSum = 1;
            while (curN > factor) {
                curSum *= factor;
                curN -= factor;
                //又因为10=3+3+4，8=3+3+2，3=1+2这些情况，最后一个因子有要拆和不拆两种情况
                if (curN >= factor && curN - factor < factor) {
                    curSum *= Math.max(curN, curN % factor * factor);
                    break;
                }
            }
            if (curSum < sum) {
                break;
            } else {
                sum = curSum;
            }
        }
        return sum;
    }

    /* 100%，两条要点：
     * 1、拆分个数一定，拆分的所有因子相等，乘积最大
     * 2、！！！最优的拆分是3，直接不用再考虑更大的因子；次优拆分2，尽量不要拆分1 */
    private int integerBreakMath(int n) {
        //当n<=3时本来不应该拆分，但是按题目要求必须要拆成两个，于是必须拆出来一个1，直接导致乘积-1
        if (n <= 3) {
            return n - 1;
        }
        int divide = n / 3, rest = n % 3;
        //Math.pow()为O(1)的Native方法
        if (rest == 0) {
            return (int) Math.pow(3, divide);
        }
        //如果余数=1，必须要借一个3拆成2*2，因为3*1<2*2
        if (rest == 1) {
            return (int) Math.pow(3, divide - 1) * 2 * 2;
        }
        //如果余数=2,也直接就这么拆
        return (int) Math.pow(3, divide) * 2;
    }
}
