package middle;

import java.util.Arrays;

public class jump45 {
    public static void main(String[] args) {
        jump45 t = new jump45();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 3, 1, 1, 4}};
        for (int[] e : eg) {
            System.out.println(jump(e));
        }
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; i + j < nums.length && j <= nums[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
