package middle;

public class rob213 {
    public static void main(String[] args) {
        rob213 t = new rob213();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 3, 2}, {1, 2, 3, 1}, {0}, {1, 2}};
        for (int[] e : eg) {
            System.out.println(rob(e));
        }
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        /* 思路:维护两个dp,一个dp可以偷0而不可以偷最后，一个dp不能偷0而可以偷最后 */
        int[] dp1 = new int[length];
        int[] dpn = new int[length];
        dp1[0] = nums[0];
        dpn[0] = 0;
        dp1[1] = Math.max(dp1[0], nums[1]);
        dpn[1] = nums[1];
        for (int i = 2; i < length; i++) {
            if (i < length - 1) {
                dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            }
            dpn[i] = Math.max(dpn[i - 2] + nums[i], dpn[i - 1]);
        }
        return Math.max(dp1[length - 2], dpn[length - 1]);
    }

}
