package easy;

import java.util.Arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        removeDuplicates t=new removeDuplicates();
        int[] nums1={1,1,2};
        int[] nums2={0,0,1,1,1,2,2,3,3,4};
        System.out.println(t.removeOriginal(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(t.removeOriginal(nums2));
        System.out.println(Arrays.toString(nums2));
    }

    public int removeOriginal(int[] nums) {
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
