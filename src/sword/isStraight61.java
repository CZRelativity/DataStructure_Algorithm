package sword;

import java.util.Arrays;

public class isStraight61 {
    public static void main(String[] args) {

    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4, 5}, {0, 0, 1, 2, 5}};

    }

    //%91
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int countZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            } else {
                if (i > 0) {
                    if (nums[i - 1] == nums[i]) {
                        return false;
                    }
                    if (nums[i - 1] != 0) {
                        //补0数=左右之差-1，只差1就是连续不用补
                        countZeros -= nums[i] - nums[i - 1] - 1;
                        if (countZeros < 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
