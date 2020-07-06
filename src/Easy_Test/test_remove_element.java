package Easy_Test;

import Easy.remove_element;

import java.util.Arrays;

public class test_remove_element {
    public static void main(String[] args) {
        remove_element t=new remove_element();
        int[] nums1={3,2,2,3};
        int[] nums2={0,1,2,2,3,0,4,2};
        System.out.println(t.remove_Original(nums1,3));
        System.out.println(Arrays.toString(nums1));
        System.out.println(t.remove_Original(nums2,2));
        System.out.println(Arrays.toString(nums2));//*老是忘记直接输出数组的方式
    }
}
