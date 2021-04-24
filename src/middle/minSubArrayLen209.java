package middle;

public class minSubArrayLen209 {
    public static void main(String[] args) {
        minSubArrayLen209 t = new minSubArrayLen209();
        t.test();
    }

    private void test() {
        int[] egS = {7,};
        int[][] egNums = {{2, 3, 1, 2, 4, 3},};
        for (int i = 0; i < egS.length; i++) {
            System.out.println(minSubArrayLen(egS[i], egNums[i]));
        }
    }

    //18%,优化
    public int minSubArrayLen(int s, int[] nums) {
        int left, right, len = 1;
        int numsLen = nums.length;
        while (len <= numsLen) {
            int sum = 0;
            left = 0;
            right = 0;
            while (right < numsLen) {
                if (right - left + 1 <= len) {
                    sum += nums[right];
                    right++;
                } else {
                    sum = sum - nums[left] + nums[right];
                    right++;
                    left++;
                }
                if (sum >= s) {
                    return len;
                }
            }
            len++;
        }
        return 0;
    }
}
