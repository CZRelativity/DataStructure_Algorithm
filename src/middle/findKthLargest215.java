package middle;

import java.util.PriorityQueue;

public class findKthLargest215 {
    public static void main(String[] args) {
        findKthLargest215 t = new findKthLargest215();
        t.test();
    }

    private void test() {
        int[][] eg = {{3, 2, 1, 5, 6, 4}, {3, 2, 3, 1, 2, 4, 5, 5, 6}};
        int[] k = {2, 4};
        for (int i = 0; i < eg.length; i++) {
            System.out.println(findKthLargest(eg[i], k[i]));
        }
    }

    //维护一个长度k的大顶堆,woc PriorityQueue这么稳的吗
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.toArray(new Integer[0])[0];
    }

}
