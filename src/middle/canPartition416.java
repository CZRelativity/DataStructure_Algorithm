package middle;

class canPartition416 {
    public static void main(String[] args) {
        canPartition416 t = new canPartition416();
        t.test();
    }

    private void test() {
        int[][] eg = {{9, 5}, {19, 33, 38, 60, 81, 49, 13, 61, 50, 73, 60, 82, 73, 29, 65, 62, 53, 29, 53, 86, 16, 83, 52, 67, 41, 53, 18, 48, 32, 35, 51, 72, 22, 22, 76, 97, 68, 88, 64, 19, 76, 66, 45, 29, 95, 24, 95, 29, 95, 76, 65, 35, 24, 85, 95, 87, 64, 97, 75, 88, 88, 65, 43, 79, 6, 5, 70, 51, 73, 87, 76, 68, 56, 57, 69, 77, 22, 27, 29, 12, 55, 58, 18, 30, 66, 53, 53, 81, 94, 76, 28, 41, 77, 17, 60, 32, 62, 62, 88, 61}
                , {2, 2, 3, 5}, {1, 2, 5}, {14, 9, 8, 4, 3, 2}, {1, 5, 11, 5}, {1, 2, 3, 5}};
        for (int[] e : eg) {
            System.out.println(canPartition(e));
        }
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[len][sum + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int curSum = 1; curSum <= sum; curSum++) {
            for (int i = 1; i < len; i++) {
                dp[i][curSum] = dp[i - 1][curSum];
                if (curSum - nums[i] >= 0) {
                    dp[i][curSum] |= dp[i - 1][curSum - nums[i]];
                }
            }
        }
        return dp[len - 1][sum];
    }
}
