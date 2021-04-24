package middle;

import java.util.HashMap;

public class subarraySum560 {
    public static void main(String[] args) {
        subarraySum560 t = new subarraySum560();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 1, 1},};
        int[] k = {2};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(subarraySum(eg[i], k[i]));
        }

    }

    //暴力，通过
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    //前缀和+HashMap
    public int subarraySum(int[] nums, int k) {
        /* 前缀和：包括指针left在内，以左所有数的和
         * map存放一个前缀和出现的次数 */
        HashMap<Integer, Integer> preSumNum = new HashMap<>();
        //用前缀和相减，preSum2-preSum1可以得到任何子数组的和
        preSumNum.put(0, 1);
        //没有单独判断preSum=k即preSum-k，
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumNum.containsKey(preSum - k)) {
                count += preSumNum.get(preSum - k);
            }
            preSumNum.put(preSum, preSumNum.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
