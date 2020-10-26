package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class fourSum18 {
    public static void main(String[] args) {
        fourSum18 t = new fourSum18();
        int[] egn1 = new int[]{1, 0, -1, 0, -2, 2};
        int egt1 = 0;
        int[] egn2 = new int[]{2, 0, 3, 0, 1, 2, 4};
        int egt2 = 7;
        int[] egn3 = new int[]{0, 0, 0, 0};
        int egt3 = 0;
        int[] egn4 = new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4};
        int egt4 = 12;
        //重复解
        int[] egn5 = new int[]{-1, -5, -5, -3, 2, 5, 0, 4};
        int egt5 = -7;
        t.fourSum(egn1, egt1);
        for (List<Integer> intList : t.res) {
            for (int i : intList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    //四指针，只有32%？
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left1, right1, left2, right2;
        int curLeft1, curRight1, curLeft2, curSum;
        for (left1 = 0; left1 < nums.length - 3; left1++) {
            //只有第一次不执行的去重机制
            if (left1 > 0 && nums[left1 - 1] == nums[left1]) {
                continue;
            }
            curLeft1 = nums[left1];
            for (right1 = nums.length - 1; left1 + 2 < right1; right1--) {
                if (right1 < nums.length - 1 && nums[right1 + 1] == nums[right1]) {
                    continue;
                }
                curRight1 = nums[right1];
                left2 = left1 + 1;
                right2 = right1 - 1;
                while (left2 < right2) {
                    curLeft2 = nums[left2];
                    curSum = curLeft1 + curLeft2 + curRight1 + nums[right2];
                    if (curSum <= target) {
                        if (curSum == target) {
                            List<Integer> curRes = new ArrayList<>();
                            Collections.addAll(curRes, curLeft1, curLeft2, nums[right2], curRight1);
                            res.add(curRes);
                        }
                        left2++;
                        //在每次移动的时候去重
                        while (left2 < right2 && nums[left2 - 1] == nums[left2]) {
                            left2++;
                        }
                    } else {
                        right2--;
                        while (right2 > left2 && nums[right2 + 1] == nums[right2]) {
                            right2--;
                        }
                    }
                }
            }
        }
        return res;
    }
}

