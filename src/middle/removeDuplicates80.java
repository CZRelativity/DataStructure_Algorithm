package middle;

import java.util.Arrays;

public class removeDuplicates80 {
    public static void main(String[] args) {
        removeDuplicates80 t = new removeDuplicates80();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 1, 1, 2, 2, 2, 3, 3, 3, 4}, {1, 1, 1,}, {1, 1, 1, 2, 2, 3}, {0, 0, 1, 1, 1, 1, 2, 3, 3}, {}, {1, 2, 3,}, {1, 1, 2, 2, 3, 3,}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(Arrays.copyOf(e, removeDuplicates(e))));
        }
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                count++;
            } else {
                //不相等的时候即对单个重复数的count结束，开始判断
                if (count > 2) {
                    //count超了几位，就要往前拷贝几位，因为拷贝的部分包含了i，所以是从nums.length-1到i-1，即拷贝长度(nums.length-i)
                    System.arraycopy(nums, i, nums, i - count + 2, nums.length - i);
                    //细节：向前拷贝同时要前移遍历的下标，否则漏掉遍历
                    i = i - count + 2;
                    len -= count - 2;
                }
                //不管超没超，count结束的时候都要把count重新置1
                count = 1;
            }
        }
        //细节：由于前面是不相等的时候判断count，而末尾的重复不能用一样的方法，所以在循环结束以后再补一次
        if (count > 2) {
            len -= count - 2;
        }
        return len;
    }
}
