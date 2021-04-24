package middle;

public class findPeakElement162 {
    public static void main(String[] args) {
        findPeakElement162 t = new findPeakElement162();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 1}, {1, 2, 1, 3, 5, 6, 4}};
        for (int[] e : eg) {
            System.out.println(findPeakElement(e));
        }
    }

    //100%
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (mid != 0 && mid != nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
            return mid;
        }
        //无序情况下的二分查找
        int ret = binarySearch(nums, left, mid - 1);
        return ret != -1 ? ret : binarySearch(nums, mid + 1, right);
    }
}
