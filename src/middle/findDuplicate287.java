package middle;

public class findDuplicate287 {
    public static void main(String[] args) {
        findDuplicate287 t = new findDuplicate287();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 2, 2, 2, 2, 2}, {}, {1, 3, 4, 2, 2}, {3, 1, 3, 4, 2}, {1, 1}, {1, 1, 2}};
        for (int[] e : eg) {
            System.out.println(findDuplicate(e));
        }
    }

    /* 重复次数超过1次，有[2,2,2,2,2,2,]这种情况
     * 100%，范围有限直接数组替代map */
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        if (n < 1) {
            return -1;
        }
        int[] count = new int[n + 1];
        for (int num : nums) {
            if (count[num] > 0) {
                return num;
            }
            count[num]++;
        }
        return -1;
    }
}
