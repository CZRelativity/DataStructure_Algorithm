package middle;

class maxSatisfied1052 {
    public static void main(String[] args) {
        maxSatisfied1052 t = new maxSatisfied1052();
        t.test();
    }

    private void test() {
        int[][] customers = {{1, 0, 1, 2, 1, 1, 7, 5}, {4, 10, 10}};
        int[][] grumpy = {{0, 1, 0, 1, 0, 1, 0, 1}, {1, 1, 0}};
        int[] X = {3, 2};
        for (int i = 0; i < customers.length; i++) {
            System.out.println(maxSatisfied(customers[i], grumpy[i], X[i]));
        }
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                max += customers[i];
            }
        }
        //双指针滑动窗口，从0起，循环后++，小于len，其实是一个for的写法
        int left = 0, right = 0, window = max;
        while (right < len) {
            if (grumpy[right] == 1) {
                window += customers[right];
            }
            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    window -= customers[left];
                }
                left++;
            }
            //注意窗口值是变化的，需要把最大值保存下来
            if (window > max) {
                max = window;
            }
            right++;
        }
        return max;
    }
}
