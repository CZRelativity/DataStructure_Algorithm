package Easy;

public class remove_duplicates {
    public int Remove_Original(int[] nums) {
        if (nums.length==0) return 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[b]) {
                b++;
                nums[b] = nums[i];
            }
        }
        return ++b;
    }
}
