package middle;

public class findMin153 {
    public static void main(String[] args) {
        findMin153 t = new findMin153();
        t.test();
    }

    private void test() {
        int[][] eg = {{3, 4, 5, 1, 2}, {4, 5, 6, 7, 0, 1, 2}, {1}};
        for (int[] e : eg) {
            System.out.println(findMin(e));
        }
    }

    //100%，双指针找旋转点
    public int findMin(int[] nums) {
        int min = nums[0];
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (nums[left] > nums[left + 1]) {
                return Math.min(min, nums[left + 1]);
            } else if (nums[right] < nums[right - 1]) {
                return Math.min(min, nums[right]);
            }
            left++;
            right--;
        }
        return min;
    }
}
