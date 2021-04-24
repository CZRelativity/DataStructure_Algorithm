package middle;

import java.util.Arrays;

public class productExceptSelf238 {
    public static void main(String[] args) {
        productExceptSelf238 t = new productExceptSelf238();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(productExceptSelf(e)));
        }
    }

    //On2 timeout
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];

//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if (j != i) {
//                    ret[j] *= nums[i];
//                }
//            }
//        }
        //每个位置都等于左边所有数乘积*右边所有数乘积
        ret[0] = 1;
        for (int i = 1; i < len; i++) {
            //先用ret维护一个dp的左边所有数乘积数组
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        /* 本来同样需要维护一个dp的右边所有数乘积数组，
        但出于题目常数空间复杂度要求，使用一个变量来动态存放 */
        int rightProduct = 1;
        for (int i = len - 2; i >= 0; i--) {
            //动态得到每个位置右边所有数乘积的数组
            rightProduct *= nums[i + 1];
            //与每个位置的左数组相乘
            ret[i] *= rightProduct;
        }
        return ret;
    }
}
