package Easy_Test;

import Easy.remove_duplicates;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test_remove_duplicates {
    public static void main(String[] args) {
        remove_duplicates t=new remove_duplicates();
        int[] nums1={1,1,2};
        int[] nums2={0,0,1,1,1,2,2,3,3,4};
        System.out.println(t.Remove_Original(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(t.Remove_Original(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
