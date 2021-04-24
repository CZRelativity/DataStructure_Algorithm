package sword;

import java.util.*;

public class findContinuousSequence57_2 {
    public static void main(String[] args) {
        findContinuousSequence57_2 t = new findContinuousSequence57_2();
        t.test();
    }

    private void test() {
        int[] target = new int[]{1, 9, 15};
        for (int t : target) {
            System.out.println(Arrays.deepToString(findContinuousSequence(t)));
        }
    }

    public int[][] findContinuousSequence(int target) {
        Deque<int[]> res = new LinkedList<>();
        /* 一个dp高斯数组，直接保存最后一个值了
         * 比如一个数可以被分成n=3项连续序列的时候，
         * 是由a,a+1,a+2组成的序列，a=(target-S2（1~n-1）)/3
         * Sn-1前n-1项和由每个循环dp */
        int gauss = 0;
        /* n+gauss+(n-1)是a=1时的边界情况，
        n*1+Sn-1此时n取得最大 */
        for (int n = 2; n + gauss + (n - 1) <= target; n++) {
            gauss += (n - 1);
            //a存在，生成a的连续序列
            if ((target - gauss) % n == 0) {
                int start = (target - gauss) / n;
                int[] sequence = new int[n];
                for (int i = 0; i < n; i++) {
                    sequence[i] = start + i;
                }
                res.addFirst(sequence);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
