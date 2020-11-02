package middle;

import java.util.Arrays;

public class searchOrderRange34 {
    public static void main(String[] args) {
        searchOrderRange34 t=new searchOrderRange34();
        t.test();
    }

    private void test(){
        int[][] eg={{5,7,7,8,8,10}};
        int[] egT={8,6};
        for(int[] e:eg){
            for(int t:egT){
                System.out.println(Arrays.toString(searchRange(e, t)));
            }
        }
    }

    //100% 啊这，二分杀疯了
    public int[] searchRange(int[] nums, int target) {
        int pos=binary(nums,0,nums.length-1,target);
        int[] res={-1,-1};
        if(pos==-1){
            return res;
        }
        int left=pos-1,right=pos+1;
        while(left>-1&&nums[left]==nums[left+1]){
            left--;
        }
        while (right<nums.length&&nums[right]==nums[right-1]){
            right++;
        }
        res[0]=left+1;
        res[1]=right-1;
        return res;
    }

    private int binary(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        int mid = (from + to) / 2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return binary(nums,from,mid-1,target);
        }
        return binary(nums,mid+1,to,target);
    }
}
