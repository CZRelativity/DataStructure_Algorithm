package easy;

import java.util.Arrays;

public class removeElement {
    public static void main(String[] args) {
        removeElement t=new removeElement();
        int[] nums1={3,2,2,3};
        int[] nums2={0,1,2,2,3,0,4,2};
        System.out.println(t.removeOriginal(nums1,3));
        System.out.println(Arrays.toString(nums1));
        System.out.println(t.removeOriginal(nums2,2));
        System.out.println(Arrays.toString(nums2));//*老是忘记直接输出数组的方式
    }

    public int removeOriginal(int[] nums, int val){
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
