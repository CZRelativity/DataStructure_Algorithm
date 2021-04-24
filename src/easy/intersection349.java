package easy;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class intersection349 {
    public static void main(String[] args) {
        intersection349 t = new intersection349();
        t.test();
    }

    private void test() {
        int[][] eg1 = {{1, 2, 2, 1}, {4, 9, 5}};
        int[][] eg2 = {{2, 2}, {9, 4, 9, 8, 4}};
        for (int i = 0; i < eg1.length; i++) {
            System.out.println(Arrays.toString(intersection(eg1[i], eg2[i])));
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        //30%
//        List<Integer> res = new ArrayList<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        for (int i = 0; i < nums1.length; i++) {
//            //注意，这个跳过也是有序的情况下才有效
//            while (i > 0 && i < nums1.length && nums1[i] == nums1[i - 1]) {
//                i++;
//            }
//            if (i == nums1.length) {
//                break;
//            }
//            //注意！使用二分查找必须有序！！！否则必须两边查找
//            int ret = Arrays.binarySearch(nums2, nums1[i]);
//            if (ret >= 0) {
//                res.add(nums1[i]);
//            }
//        }
//        return res.stream().mapToInt(Integer::intValue).toArray();

        //14%
        List<Integer> res = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        for (Integer i : set1) {
            if (set2.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
