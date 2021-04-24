package middle;

public class equalSubstring1208 {
    public static void main(String[] args) {
        equalSubstring1208 t = new equalSubstring1208();
        t.test();
    }

    private void test() {
        String[] s = {"abcd", "abcd", "abcd"};
        String[] t = {"bcdf", "cdef", "acde"};
        int[] cost = {3, 3, 0};
        for (int i = 0; i < s.length; i++) {
            System.out.println(equalWindow(s[i], t[i], cost[i]));
        }
    }

    //超级暴力解，居然没超时，改滑动窗口
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length(), max = 0;
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i = 0; i < len; i++) {
            int curCost = 0, j = i;
            while (j < len && curCost + cost[j] <= maxCost) {
                curCost += cost[j];
                j++;
            }
            if (j - i > max) {
                max = j - i;
            }
        }
        return max;
    }

    //91.44%，滑动窗口，确实是O(n)，窗口只会变大不会变小
    public int equalWindow(String s, String t, int maxCost) {
        int len = s.length(), max = 0;
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0, curCost = 0;
        while (right < len) {
            curCost += cost[right];
            if (curCost <= maxCost) {
                max = Math.max(right - left + 1, max);
            } else {
                curCost -= cost[left];
                left++;
            }
            right++;
        }
        return max;
    }
}

