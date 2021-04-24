package easy;

public class canThreePartsEqualSum1013 {
    public static void main(String[] args) {
        canThreePartsEqualSum1013 t = new canThreePartsEqualSum1013();
        t.test();
    }

    private void test() {
        int[][] eg = {{10, -10, 10, -10, 10, -10, 10, -10}, {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}, {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1},
                {3, 3, 6, 5, -2, 2, 5, 1, -9, 4},};
        for (int[] e : eg) {
            System.out.println(canThreePartsEqualSum(e));
        }
    }

    /* 题目说了是划分呀，那就是说满足sum/3的一定是连续的，要找的确实只是两个索引i和j存不存在
     * 没认真读题 */
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int curSum = 0;
        int parts = 0;
        for (int num : arr) {
            curSum += num;
            if (curSum == sum) {
                curSum = 0;
                parts++;
            }
        }
        //因为0+0=0，可以分出4个0
        return parts == 3 || (sum == 0 && parts > 3);
    }

}
