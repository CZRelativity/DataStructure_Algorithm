package easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class intersect350 {
    public static void main(String[] args) {
        intersect350 t = new intersect350();
        t.test();
    }

    private void test() {
        int[][] eg1 = {{1, 2, 2, 1}, {4, 9, 5}, {1, 1, 1, 1,}};
        int[][] eg2 = {{2, 2}, {9, 4, 9, 8, 4}, {}};
        for (int i = 0; i < eg1.length; i++) {
            System.out.println(Arrays.toString(intersectHash(eg1[i], eg2[i])));
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p2 = 0;
        List<Integer> ret = new ArrayList<>();
        for (int i : nums1) {
            while (p2 < nums2.length && i >= nums2[p2]) {
                if (i == nums2[p2]) {
                    ret.add(i);
                    p2++;
                    break;
                }
                p2++;
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] intersectHash(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = Arrays.stream(nums1).boxed().
                collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        Map<Integer, Integer> count2 = Arrays.stream(nums2).boxed().
                collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        List<Integer> ret = new ArrayList<>();
        for (int key : count1.keySet()) {
            if (count2.containsKey(key)) {
                int times = Math.min(count1.get(key), count2.get(key));
                for (int i = 0; i < times; i++) {
                    ret.add(key);
                }
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
