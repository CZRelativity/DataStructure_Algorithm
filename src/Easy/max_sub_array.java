package Easy;

public class max_sub_array {

    public static void main(String[] args) {
        max_sub_array t=new max_sub_array();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(t.Max_Original(nums));
    }

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
