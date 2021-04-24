package sword;

import java.util.Arrays;

public class exchange21 {
    public static void main(String[] args) {
        exchange21 t = new exchange21();
        t.test();
    }

    private void test() {
        int[][] eg = {{}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(exchange(e)));
        }
    }

    //27%
    public int[] exchange(int[] nums) {
        if (nums.length < 1) {
            return nums;
        }
        int even = nums.length, odd = 0;
        while (odd < even) {
            if (nums[odd] % 2 == 0) {
                even--;
                while (nums[even] % 2 == 0) {
                    even--;
                    if (even <= odd) {
                        return nums;
                    }
                }
                swap(nums, odd, even);
            }
            odd++;
        }
        return nums;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
