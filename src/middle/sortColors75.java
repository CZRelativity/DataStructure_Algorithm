package middle;

import java.util.Arrays;

public class sortColors75 {
    public static void main(String[] args) {
        sortColors75 t = new sortColors75();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 0, 2, 1, 1, 0}, {}};
        for (int[] e : eg) {
            sortColors(e);
            System.out.println(Arrays.toString(e));
        }
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int mark = right;
        int markNum = nums[mark];
        /* 单看快排的循环其实也是一个双指针，右指针是挑选的快排基准位
         * 左指针之前已经确定不大于基准位，左指针以后待比较 */
        for (int i = left; i < mark; ) {
            if (nums[i] > markNum) {
                int j = i;
                while (j < mark) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    j++;
                }
                mark--;
            } else {
                i++;
            }
        }
        quickSort(nums, left, mark - 1);
        quickSort(nums, mark + 1, right);
    }

}
