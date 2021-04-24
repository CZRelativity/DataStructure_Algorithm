package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow239 {
    public static void main(String[] args) {
        maxSlidingWindow239 t = new maxSlidingWindow239();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 3, -1, -3, 5, 3, 6, 7}, {}};
        int[] egK = {3, 0};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(Arrays.toString(maxSlidingWindow(eg[i], egK[i])));
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /* 双向队列里面存的是下标，因为从值去找下标很难，但是从下标找值就很简单
         * 双向队列的原因：要判断队列最前是不是出窗口了，
         * 也要在插入的时候从末尾依次弹出使队列保持大的在最前面 */
        Deque<Integer> indexQ = new LinkedList<>();
        int left;
        int[] maxArr = new int[nums.length - k + 1];
        //滑动窗口右指针
        for (int right = 0; right < nums.length; right++) {
            //滑动窗口左指针
            left = right - k + 1;
            /* 确实每次只会有一个出窗口，但是只判断队列最前是不是出窗口了？
            会不会导致中间其实出窗口了但是还在队列的情况？但是确实ac了 */
            if (!indexQ.isEmpty() && indexQ.getFirst() < left) {
                indexQ.removeFirst();
            }
            //从队末（值最小）开始弹出，直至插入点，保证了整个下标队列对应的值队列严格倒序
            while (!indexQ.isEmpty() && nums[indexQ.getLast()] < nums[right]) {
                indexQ.removeLast();
            }
            indexQ.add(right);
            if (left >= 0) {
                maxArr[left] = nums[indexQ.getFirst()];
            }
        }
        return maxArr;
    }
}
