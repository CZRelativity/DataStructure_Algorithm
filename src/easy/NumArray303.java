package easy;

public class NumArray303 {

    public static void main(String[] args) {
        NumArray303 t = new NumArray303();
        t.test();
    }

    private void test() {
        int[] egArr = {-2, 0, 3, -5, 2, -1};
        int[][] egRange = {{0, 2}, {2, 5}, {0, 5}};
        NumArray numArray = new NumArray(egArr);
        for (int[] ints : egRange) {
            System.out.println(numArray.sumRange(ints[0], ints[1]));
        }
    }

    class NumArray {

        int[] nums;
        int[] dp;

        public NumArray(int[] nums) {
            this.nums = nums;
            if (nums.length == 0) {
                return;
            }
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? dp[j] : dp[j] - dp[i - 1];
        }
    }
}
