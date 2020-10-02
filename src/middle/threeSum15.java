package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class threeSum15 {
    public static void main(String[] args) {
        threeSum15 t = new threeSum15();
        int[] example1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] example2 = new int[]{0, 0, 0, 0, 0};
        int[] example3 = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] example4 = new int[]{-1, 0, 1};
        int[] example5 = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> result = t.solveDoublePointer(example5);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    //时间6%
    public List<List<Integer>> solveOriginal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 3 || nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }
        Integer curLeft = null, curRight = null;
        for (int left = 0; nums[left] <= 0 && left < length - 2; left++) {
            if (curLeft == null || nums[left] != curLeft) {
                curLeft = nums[left];
                for (int right = length - 1; nums[right] >= 0 && right > left; right--) {
                    if (curRight == null || nums[right] != curRight) {
                        curRight = nums[right];
                        int compensateIndex = binarySearch(nums, left + 1, right - 1, -curLeft - curRight);
                        if (compensateIndex != -1) {
                            List<Integer> list = new ArrayList<>();
                            //隐式添加，爱了爱了
                            Collections.addAll(list, curLeft, curRight, nums[compensateIndex]);
                            result.add(list);
                        }
                    }
                }
                curRight = null;
            }
        }
        return result;
    }

    //时间7%
    public List<List<Integer>> solveDoublePointer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 3 || nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }
        int left = 0, right = length - 1;
        Integer curLeft, curRight = null;
        while (nums[left] <= 0 && left < right) {
            if (nums[right] < 0 || nums[left] + nums[right] * 2 < 0) {
                if (nums[left] != nums[left + 1]) {
                    right = length - 1;
                    curRight = null;
                }
                left++;
            } else {
                if (curRight == null || nums[right] != curRight) {
                    curLeft = nums[left];
                    curRight = nums[right];
                    int curCompensateIndex = binarySearch(nums, left + 1, right - 1, -curLeft - curRight);
                    if (curCompensateIndex != -1) {
                        List<Integer> list = new ArrayList<>();
                        Collections.addAll(list, curLeft, nums[curCompensateIndex], curRight);
                        result.add(list);
                    }
                }
                right--;
            }
        }
        return result;
    }

    public int binarySearch(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        int mid = (from + to) / 2;
        int result;
        if (nums[mid] == target) {
            result = mid;
        } else if (nums[mid] > target) {
            result = binarySearch(nums, from, mid - 1, target);
        } else {
            result = binarySearch(nums, mid + 1, to, target);
        }
        return result;
    }
}
