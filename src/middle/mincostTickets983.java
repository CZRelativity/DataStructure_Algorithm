package middle;

class mincostTickets983 {
    public static void main(String[] args) {
        mincostTickets983 t = new mincostTickets983();
        t.test();
    }

    private void test() {
        int[][] days = {{1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29}, {1, 4, 6, 7, 8, 20}, {1}, {1, 4, 6, 7, 8, 20}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}};
        int[][] costs = {{3, 14, 50}, {7, 2, 15}, {2, 7, 15}, {2, 7, 15}, {2, 7, 15}};
        for (int i = 0; i < days.length; i++) {
            System.out.println(mincostTickets(days[i], costs[i]));
        }
    }

    //日了，比想的要难
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int pDays = 0;
        int[] dp = new int[lastDay + 1];
        /* 因为[7,2,15]这种票价，7天票可能比1天票还便宜（爬）
         * 因为每种票都能满足一天，所以每一天都应该买最便宜的票，不一定是单日票（坑） */
        int minSingle = Math.min(costs[0], Math.min(costs[1], costs[2]));
        dp[0] = 0;
        for (int day = 1; day <= lastDay; day++) {
            /* 基本状态表达式：
             * 截止某天的最低花费：
             * 当天不旅行：昨天花费
             * 当天旅行：昨天花费+1天票/7天票+7天前花费（没有就0）/30天票+30天前花费 */
            dp[day] = dp[day - 1];
            if (day == days[pDays]) {
                dp[day] += minSingle;
                pDays++;
            }
            /* 7天以下当然也可以买7天票 */
            int t7 = costs[1];
            if (day >= 7) {
                t7 += dp[day - 7];
            }
            /* 30天以下当然也可以买30天票，不是超过30天才能买，
            而是30天过后才因为不能完全覆盖而需要加上30天前的花费 */
            int t30 = costs[2];
            if (day >= 30) {
                t30 += dp[day - 30];
            }
            dp[day] = Math.min(dp[day], Math.min(t7, t30));

        }
        return dp[lastDay];
    }
}
