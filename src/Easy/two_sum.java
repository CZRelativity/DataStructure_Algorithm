package Easy;

public class two_sum {
    public int[] Two_Sum_Original(int[] nums, int target) {
        int[] index = new int[]{0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
}
