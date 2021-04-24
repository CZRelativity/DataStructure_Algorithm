package middle;

import tools.GeneralTool;

import java.util.Arrays;
import java.util.List;

public class minimumTotal120 {
    public static void main(String[] args) {
        minimumTotal120 t = new minimumTotal120();
        t.test();
    }

    private void test() {
        String[] eg = {"[[2],[3,4],[6,5,7],[4,1,8,3]]", "[[-10]]", "[[1],[2,3]]"};
        for (String e : eg) {
            System.out.println(minimumTotalOn(GeneralTool.getList2(e)));
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int minTotal = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle.get(i).get(0);
                } else if (j == 0) {
                    dp[i][j] = triangle.get(i).get(0) + dp[i - 1][0];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                if (i == n - 1 && dp[i][j] < minTotal) {
                    minTotal = dp[i][j];
                }
            }
        }
        return minTotal;
    }

    /* O(n)要点：自下而上，规避边界；最后结果一定固定在dp[0]
     * dp[]只需一行，随dp不断覆盖，又不会有影响，因为自下而上是利用这一位和后一位dp出这一位 */
    public int minimumTotalOn(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
