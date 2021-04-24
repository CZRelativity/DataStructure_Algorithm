package middle;

import java.util.Arrays;
import java.util.Stack;

public class dailyTempratures739 {
    public static void main(String[] args) {
        dailyTempratures739 t = new dailyTempratures739();
        t.test();
    }

    private void test() {
        int[][] eg = {{73, 74, 75, 71, 69, 72, 76, 73}};
        for (int[] e : eg) {
            System.out.println(Arrays.toString(dailyTemp(e)));
        }
    }

    //暴力,10%
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = 0;
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /* 单调栈32%
     * 如果当前元素比栈顶大，则让小项逐个出栈，直到当前元素比栈顶小，停止出栈
     * 此时栈顶元素就是当前项右边的第一个比自己大的元素索引，计算距离
     * 从索引找元素简单，从元素到索引难，所以这里栈里肯定是存的索引
     * 然后当前项入栈 */
    public int[] dailyT(int[] T) {
        Stack<Integer> minTopStack = new Stack<>();
        int len = T.length;
        int[] ret = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!minTopStack.isEmpty() && T[i] >= T[minTopStack.peek()]) {
                minTopStack.pop();
            }
            if (minTopStack.isEmpty()) {
                ret[i] = 0;
            } else {
                ret[i] = minTopStack.peek() - i;
            }
            minTopStack.push(i);
        }
        return ret;
    }

    public int[] dailyTemp(int[] T) {
        int len = T.length;
        int[] ret = new int[len];
        Stack<Integer> maxBottomStack = new Stack<>();
        ret[len - 1] = 0;
        maxBottomStack.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            while (!maxBottomStack.isEmpty() && T[i] >= T[maxBottomStack.peek()]) {
                maxBottomStack.pop();
            }
            if (maxBottomStack.isEmpty()) {
                ret[i] = 0;
            } else {
                ret[i] = maxBottomStack.peek() - i;
            }
            maxBottomStack.push(i);
        }
        return ret;
    }
}
