package Easy;

public class remove_element {
    public int remove_Original(int[] nums, int val){
        if (nums.length==0)return 0;
        int b=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[b++]=nums[i];
            }
        }
        return b;
    }
}
