package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class threeSum15 {
    public static void main(String[] args) {
        threeSum15 t = new threeSum15();
        int[][] eg = {{-1, 0, 1, 2, -1, -4}, {0, 0, 0, 0, 0}, {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, {-1, 0, 1}, {-2, 0, 1, 1, 2}};
        for (int[] e : eg) {
            t.threeSum(e).forEach(System.out::println);
            System.out.println();
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

    private int binarySearch1(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            //去重
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            while (left < right - 1) {
                //去重
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (binarySearch1(nums, left + 1, right - 1, -nums[left] - nums[right]) != -1) {
                    List<Integer> e = new ArrayList<>();
                    Collections.addAll(e, nums[left], -nums[left] - nums[right], nums[right]);
                    ret.add(e);
                }
                right--;
            }
            left++;
            right = nums.length - 1;
        }
        return ret;
    }
}
