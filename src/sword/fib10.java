package sword;

public class fib10 {
    public static void main(String[] args) {
        fib10 t = new fib10();
        t.test();
    }

    private void test() {
        int[] eg = {0, 1, 100};
        for (int e : eg) {
            System.out.println(fib(e));
        }
    }

    /* 结果取模1000000007(1e9+7)，可以规避溢出
     * 取模运算其实就是求余运算 */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            /* 一到1e9+7以上就取余生效，在我们的状态转换式下不会出现2倍1e9+7的情况
             * 所以可以直接看作减法 */
            if (dp[i] > 1000000007) {
                dp[i] -= 1000000007;
            }
            System.out.println(i + " " + dp[i]);
        }
        return dp[n];
    }
}
