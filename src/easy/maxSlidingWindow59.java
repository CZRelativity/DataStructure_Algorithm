package easy;

import java.util.Arrays;

public class maxSlidingWindow59 {
    public static void main(String[] args){
        maxSlidingWindow59 t=new maxSlidingWindow59();
        int[] eg1=new int[]{1,3,-1,-3,5,3,6,7};
        int[] eg2=new int[]{};
        int[] eg3=new int[]{1};
        int[] res=t.maxSlidingWindow(eg1,3);
        System.out.println(Arrays.toString(res));
    }

    //双指针，97%，92%
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[]{};
        }
        int left=0,right=-1,curMax=Integer.MIN_VALUE;
        int[] maxArr=new int[nums.length-k+1];
        //为了使k=1时也可以进循环，而且要
        while(k>0){
            right++;
            if(nums[right]>curMax){
                curMax=nums[right];
            }
            k--;
        }
        maxArr[left]=curMax;
        while(right<nums.length-1){
            right++;
            left++;
            if(curMax==nums[left-1]){
                curMax=nums[left];
                for(int i=left;i<right;i++){
                    if(nums[i]>curMax){
                        curMax=nums[i];
                    }
                }
            }
            if(nums[right]>curMax){
                curMax=nums[right];
            }
            maxArr[left]=curMax;
        }
        return maxArr;
    }
}
