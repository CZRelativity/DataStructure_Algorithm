package Easy;

public class max_sub_array {
    public int Max_Original(int[] nums) {
        int sum = 0, temp = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else sum = num;
            temp = Math.max(sum, temp);
        }
        return temp;
    }
}
