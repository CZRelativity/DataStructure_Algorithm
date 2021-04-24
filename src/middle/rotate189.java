package middle;

import java.util.Arrays;

public class rotate189 {
    public static void main(String[] args) {
        rotate189 t = new rotate189();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7}, {-1, -100, 3, 99}};
        int[] k = {7, 9, 2};
        for (int i = 0; i < eg.length; i++) {
            rotate(eg[i], k[i]);
            System.out.println(Arrays.toString(eg[i]));
        }
    }

    //这是什么神仙方法哭了
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

//    private void swapK(int[] nums, int p1, int p2, int k) {
//        for (int i = 0; i < k; i++) {
//            int temp = nums[p1];
//            nums[p1] = nums[p2];
//            nums[p2] = temp;
//            p1++;
//            p2++;
//        }
//    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
