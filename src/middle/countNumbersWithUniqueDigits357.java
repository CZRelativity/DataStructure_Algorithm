package middle;

public class countNumbersWithUniqueDigits357 {
    public static void main(String[] args) {
        countNumbersWithUniqueDigits357 t = new countNumbersWithUniqueDigits357();
        t.test();
    }

    private void test() {
        int[] eg = {0, 1, 2, 3,};
        for (int i : eg) {
            System.out.println(countUnique(i));
        }
    }

    boolean[] used;
    int count;

    public int countNumbersWithUniqueDigits(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            used = new boolean[10];
//            count = 0;
//            dfs(0, i);
//            dp[i] = count + dp[i - 1];
//        }
//        return dp[n];
        count = 0;
        used = new boolean[10];
        dfs(0, n);
        return count;
    }

    /* unique -> boolean[] used
     * 纯深搜解法，很慢 */
    private void dfs(int bit, int n) {
        count++;
        for (int i = 0; i < 10; i++) {
            //剪枝，首位为0
            if (i == 0 && bit == 0) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                /* 希望在这里做判断，不要新开一个数量级的栈，
                但是最终表现对时间的影响不大 */
                if (bit + 1 <= n) {
                    dfs(bit + 1, n);
                }
                used[i] = false;
            }
        }
    }

    /* 数学，排列组合+dp解法，100%
     * n=1:10种
     * 2:C91C91 9*9（多位数首位不为0）
     * 3:C91C91C81 9*9*8
     * 4:C91C91C81C71 9*9*8*7 */
    public int countUnique(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //从数学上讲不对但是这道题dp[0]确实等于1
        for (int i = 1; i <= n; i++) {
            //姑且n=1及以上都有C91吧
            dp[i] = 9;
            //n=2开始，比如第二位*8，第三位*7
            for (int bit = 1; bit < i; bit++) {
                dp[i] *= (10 - bit);
            }

            dp[i] += dp[i - 1];
        }
        return dp[n];
    }
}
