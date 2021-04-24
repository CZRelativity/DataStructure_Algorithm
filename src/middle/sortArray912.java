package middle;

import java.util.Arrays;

class sortArray912 {

    public static void main(String[] args) {
        sortArray912 t = new sortArray912();
        t.test();
    }

    private void test() {
        int[][] eg = {{5, 2, 3, 1}, {1, 2, 3, 4, 5, 6, 7}, {5, 1, 1, 2, 0, 0}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(sortArray(e)));
        }
    }

    public int[] sortArray(int[] nums) {
        //第一个非叶子结点，公式length/2-1
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        for (int i = len / 2 - 1; i >= 0; i--) {
            getMaxTopHeap(nums, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            getMaxTopHeap(nums, 0, i);
        }
        return nums;
    }

    private void getMaxTopHeap(int[] nums, int top, int len) {
        if (top > (len - 1) / 2) {
            return;
        }
        //非叶子结点的左结点，公式2*i+1,右结点，公式2*i+2
        int left = 2 * top + 1;
        int right = 2 * top + 2;
        int max = nums[top];
        int maxIndex = top;
        if (left < len && nums[left] > max) {
            max = nums[left];
            maxIndex = left;
        }
        if (right < len && nums[right] > max) {
            maxIndex = right;
        }
        if (maxIndex != top) {
            swap(nums, top, maxIndex);
            getMaxTopHeap(nums, maxIndex, len);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

}
