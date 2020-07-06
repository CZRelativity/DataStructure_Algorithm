package Easy;

public class search_insert {
    public int Search_Original(int[] nums,int target){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                return i;
            }
            if (nums[i]<target)j++;
        }
        return j;
    }

    public int Search_Middle(int[] nums,int target){//此为二分查找模版
        int left=0,right=nums.length-1,mid;
        while (left<=right){
            mid=(left+right)/2;
            if (target==nums[mid]){
                return mid;
            }else if (target<nums[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
