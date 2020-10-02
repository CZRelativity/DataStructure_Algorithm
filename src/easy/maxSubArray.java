package easy;

public class maxSubArray {

    public static void main(String[] args) {
        maxSubArray t = new maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t.solveOriginal(nums));
    }

    public int solveOriginal(int[] nums) {
        int sum = 0, curMaxSum = nums[0];
        for (int num : nums) {
            //如果前面子串的和大于0，那么可以直接往上加，因为总对下一个添加的数来说是增益
            if (sum > 0) {
                sum += num;
                //如果前面子串的和已经小于0了，那么就舍去了，舍去的方法是从下一个数开始重新计子串和
            } else {
                sum = num;
            }
            //如果子串和已经比记录的大了，就更新
            curMaxSum = Math.max(sum, curMaxSum);
        }
        return curMaxSum;
    }
}
