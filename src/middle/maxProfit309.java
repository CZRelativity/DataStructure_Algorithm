package middle;

public class maxProfit309 {
    public static void main(String[] args) {
        maxProfit309 t = new maxProfit309();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 0, 2}};
        for (int[] e : eg) {
            System.out.println(maxProfit(e));
        }
    }

    //有限状态机？99.3%
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][3];
        /* 状态0，不持股 不买入 不卖出
        可能的原因1、继承昨天的0状态，2、昨天卖出了，今天是冷冻期 */
        dp[0][0] = 0;
        /* 状态1，持股状态
         * 可能的原因1、继承昨天的持股状态1，2、昨天是不持股状态0，今天买入，不能是不持股状态2 */
        dp[0][1] = -prices[0];
        /* 状态2，因为今天卖出所以不持股的状态，第0天没有持股，所以卖出初始化为0
         * 前一天的状态只能是持股状态1 */
        dp[0][2] = 0;
        //区分了可以买入的不持股状态0和不能买入的不持股状态2
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
