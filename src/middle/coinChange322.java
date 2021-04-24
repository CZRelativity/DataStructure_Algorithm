package middle;

import java.util.Arrays;

public class coinChange322 {
    public static void main(String[] args) {
        coinChange322 t = new coinChange322();
        t.test();
    }

    private void test() {
        int[][] egC = {{186, 419, 83, 408}, {1, 2, 5}, {2}, {1}, {1}, {1}};
        int[] egA = {6249, 11, 3, 0, 1, 2};
        for (int i = 0; i < egC.length; i++) {
            System.out.println(coinChangeDp(egC[i], egA[i]));
        }
    }

    //如果大硬币用多了导致凑不出来，应该回溯减少大硬币数量
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
            if (amount == 0) {
                return count;
            }
        }
        return -1;
    }

    //看作动态规划典型n背包问题
    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (curAmount - coins[j] >= 0 && dp[curAmount - coins[j]] < min) {
                    min = dp[curAmount - coins[j]] + 1;
                }
            }
            dp[curAmount] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
