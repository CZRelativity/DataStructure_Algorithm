package middle;

import java.util.Arrays;

public class maxProduct152 {
    public static void main(String[] args) {
        maxProduct152 t = new maxProduct152();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 3, -2, 4}, {-2, 0, -1}};
        for (int[] e : eg) {
            System.out.println(maxProduct(e));
        }
    }

    //dp ? 符号 ?
    public int maxProduct(int[] nums) {
        int length = nums.length;
        /* 这是dp吗？我觉得是维护的一个最大值一个最小值两个窗口
         * 因为一个负数就可以使最大值最小值交换，然后用了一个单独的变量来动态改变最大结果 */
        int[] windowPlus = new int[length];
        int[] windowMinus = new int[length];
        int max = nums[0];
        windowPlus[0] = nums[0];
        windowMinus[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] < 0) {
                /* 当nums[i]<0的时候无论符号，最大值窗口与其相乘一定会得到最小值，同理
                 * 最小值窗口与其相乘一定会得到最大值 */
                windowPlus[i] = Math.max(windowMinus[i - 1] * nums[i], nums[i]);
                windowMinus[i] = Math.min(windowPlus[i - 1] * nums[i], nums[i]);
            } else {
                windowPlus[i] = Math.max(windowPlus[i - 1] * nums[i], nums[i]);
                windowMinus[i] = Math.min(windowMinus[i - 1] * nums[i], nums[i]);
            }
            if (windowPlus[i] > max) {
                max = windowPlus[i];
            }
        }
        return max;
    }
}
