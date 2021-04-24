package middle;

class findLength718 {
    public static void main(String[] args) {
        findLength718 t = new findLength718();
        t.test();
    }

    private void test() {
        int[][] A = {{1, 2, 3, 2, 1}};
        int[][] B = {{3, 2, 1, 4, 7}};
        for (int i = 0; i < A.length; i++) {
            System.out.println(findLength(A[i], B[i]));
        }
    }

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = 0;
        /* 状态转移方程：
         * 1、
         * 2、 */
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i1 = 1; i1 <= len1; i1++) {
            for (int i2 = 1; i2 <= len2; i2++) {
                if (nums1[i1 - 1] != nums2[i2 - 1]) {
                    dp[i1][i2] = 0;
                } else {
                    dp[i1][i2] = dp[i1 - 1][i2 - 1] + 1;
                    if (dp[i1][i2] > max) {
                        max = dp[i1][i2];
                    }
                }
            }
        }
        return max;
    }
}
