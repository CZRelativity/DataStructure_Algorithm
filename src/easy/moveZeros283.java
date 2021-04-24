package easy;

import java.util.Arrays;

public class moveZeros283 {
    public static void main(String[] args) {
        moveZeros283 t = new moveZeros283();
        t.test();
    }

    private void test() {
        int[][] eg = {{}, {0, 0, 0, 0,}, {0, 1, 0, 3, 12}};
        for (int[] e : eg) {
            countZeros(e);
            System.out.println(Arrays.toString(e));
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right >= 0 && nums[right] == 0) {
            right--;
        }
        //跟快排移动思路差不多，但是对这道题慢了
        while (left < right) {
            if (nums[left] == 0) {
                int i = left;
                //最后一次是在right-1的时候和right交换
                while (i < right) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                    i++;
                }
                right--;
                /* 细节，做了交换的循环里面是不移动left的，
                因为后一个还没有判断的数被移到了现在left的位置上 */
            } else {
                left++;
            }
        }
    }

    //100%,其实parse数的是 不是0的 个数
    public void countZeros(int[] nums) {
        int parse = 0, i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (parse != i) {
                    nums[parse] = nums[i];
                }
                parse++;
            }
        }
        while (parse < nums.length) {
            nums[parse] = 0;
            parse++;
        }
    }
}
