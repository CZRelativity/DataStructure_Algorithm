package sword;

import java.util.Arrays;

public class singleNumbers56_1 {
    public static void main(String[] args) {
        singleNumbers56_1 t = new singleNumbers56_1();
        t.test();
    }

    private void test() {
        int[][] eg = {{4, 1, 4, 6}, {1, 2, 10, 4, 1, 4, 3, 3}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(singleNumbers(e)));
        }
    }

    public int[] singleNumbers(int[] nums) {
        int xor = nums[0];
        /* 思路：所有出现两次的数与自身异或运算的结果为0（连连看？）
         * 两个只出现一次的数，最后他们的异或结果反映了
         * 这两个数的哪些二进制位有所不同，
         * 我们要做的是根据这一点把整个数组分成两个部分，
         * 于是两个只出现一次的数被分到两边
         * 两边的所有数分别求异或，就可以直接得到两个只出现一次的数 */
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        /* Integer.lowestOneBit/highestOneBit
        返回二进制至多有一位“1”的int值，“1”的位置是传入int的最低/最高“1”位置 */
        int and = Integer.lowestOneBit(xor);
        int[] ret = new int[2];
        for (int num : nums) {
            /* 例如两个数有最后一位不同，则两个数与以上方法的返回值 00...01相与
             * 必得到00...01和00...00，可以分出两个数 */
            if ((num & and) == and) {
                if (ret[0] == 0) {
                    ret[0] = num;
                } else {
                    ret[0] ^= num;
                }
            } else {
                if (ret[1] == 0) {
                    ret[1] = num;
                } else {
                    ret[1] ^= num;
                }
            }
        }
        return ret;
    }
}
