package middle;

import java.util.ArrayList;
import java.util.List;

public class bulbSwitch319 {
    public static void main(String[] args) {
        bulbSwitch319 t = new bulbSwitch319();
        t.test();
    }

    private void test() {
        int[] eg = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        for (int e : eg) {
            System.out.println(rule(e));
        }
    }

    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                bulb[j] = !bulb[j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (bulb[i]) {
                count++;
            }
        }
        return count;
    }

    private int rule(int n) {
        int ret = 0;
        int stepLen = 1, step = 0, value = 0;
        for (int i = 0; i < n + 1; i++) {
            ret = value;
            step++;
            if (step == stepLen) {
                stepLen += 2;
                step = 0;
                value++;
            }
        }
        return ret;
    }
}
