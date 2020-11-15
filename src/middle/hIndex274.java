package middle;

import java.util.Arrays;

public class hIndex274 {
    public static void main(String[] args) {
        hIndex274 t = new hIndex274();
        t.test();
    }

    private void test() {
        int[][] eg = {{3, 0, 6, 1, 5}, {0, 10, 20}, {}, {1}};
        for (int[] e : eg) {
            System.out.println(hIndex(e));
        }
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int h = 0;
        /* i表示几篇文章，排序以后倒序查找，citations[length-i]表示这几篇文章的最低
         * 被引，按篇数查找，因为篇数总是累加的，但是被引量却是跳的 */
        for (int i = 1; i <= length; i++) {
            if (citations[length - i] >= i) {
                h = i;
            }
        }
        return h;
    }
}
