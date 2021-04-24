package middle;

import java.util.Arrays;
import java.util.List;

public class lengthOfLIS300 {
    public static void main(String[] args) {
        lengthOfLIS300 t = new lengthOfLIS300();
        t.test();
    }

    private void test() {
        int[][] eg = {{0, 1, 0, 3, 2, 3}, {1, 3, 6, 7, 9, 4, 10, 5, 6}, {10, 9, 2, 5, 3, 7, 101, 18}};
        for (int[] e : eg) {
            System.out.println(lengthOfLIS2(e));
        }
    }

    //并非优解
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        /* dp是包含当前位置的最长上升子序列，
        状态表达式是从前面比当前位置小的数里面找最大的dp+1 */
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    //优化dp，贪心算法？

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] LIS = {nums[0]};
        for (int i = 1; i < nums.length; i++) {
            LIS = binary(LIS, nums[i]);
        }
        return LIS.length;
    }

    /* 维护一个有序的最长子序列，比整个序列大的时候直接插入，否则二分找第一个比他大的数替换
     * 序列不一定是对的！！！因为长度不变的时候也会不断地替换。但是长度一定是对的 */
    private int[] binary(int[] LIS, int insert) {
        int len = LIS.length;
        if (insert > LIS[len - 1]) {
            int[] ret = Arrays.copyOf(LIS, len + 1);
            ret[len] = insert;
            return ret;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (LIS[mid] >= insert && (mid == 0 || LIS[mid - 1] < insert)) {
                LIS[mid] = insert;
                break;
            }
            if (LIS[mid] > insert) {
                right = mid - 1;
            }
            if (LIS[mid] < insert) {
                left = mid + 1;
            }
        }
        return LIS;
    }
}
