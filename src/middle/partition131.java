package middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class partition131 {
    public static void main(String[] args) {
        partition131 t = new partition131();
        t.test();
    }

    private void test() {
        String[] eg = {"aab"};
        for (String e : eg) {
            partition(e);
            res.forEach(System.out::println);
        }
    }

    List<List<String>> res;
    String s;
    char[] chars;

    //100%
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        this.s = s;
        chars = s.toCharArray();
        dfs(new LinkedList<>(), 0);
        return res;
    }

    private void dfs(Deque<String> cur, int left) {
        if (left == chars.length) {
            res.add(new ArrayList<>(cur));
        }
        //因为可以将当前索引分割成单独一位，所以left和right开始可以是同一索引
        for (int right = left; right < chars.length; right++) {
            if (isPalin(left, right)) {
                //subString方法需要索引到end后一位
                cur.add(s.substring(left, right + 1));
                //到right已经被分割，下次dfs从right加一开始
                dfs(cur, right + 1);
                cur.removeLast();
            }
        }
    }

    private boolean isPalin(int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
