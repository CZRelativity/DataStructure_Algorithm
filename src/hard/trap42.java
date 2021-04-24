package hard;

public class trap42 {
    public static void main(String[] args) {
        trap42 t = new trap42();
        t.test();
    }

    private void test() {
        int[][] eg = {{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, {4, 2, 0, 3, 2, 5}};
        for (int[] e : eg) {
            System.out.println(trap(e));
        }
    }

    //50% 动态规划常可以优化空间复杂度 -> 
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0] = height[0];
        maxRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int minEdge = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < minEdge) {
                sum += minEdge - height[i];
            }
        }
        return sum;
    }
}
