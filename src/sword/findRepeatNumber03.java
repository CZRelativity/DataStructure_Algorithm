package sword;

public class findRepeatNumber03 {
    public static void main(String[] args) {
        findRepeatNumber03 t = new findRepeatNumber03();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 3, 1, 0, 2, 5, 3}};
        for (int[] e : eg) {
            System.out.println(findRepeatNumber(e));
        }
    }

    //map20%,数组替代map87%
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int i : nums) {
            if (count[i] > 0) {
                return i;
            }
            count[i]++;
        }
        return -1;
    }
}
