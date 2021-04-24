package middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class combine77 {
    public static void main(String[] args) {
        combine77 t = new combine77();
        t.test();
    }

    private void test() {
        int[] egN = {4, 1};
        int[] egK = {2, 1};
        for (int i = 0; i < egK.length; i++) {
            combine(egN[i], egK[i]);
            res.forEach(System.out::println);
        }
    }

    List<List<Integer>> res;
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;
        dfs(new LinkedList<>(), 1);
        return res;
    }

    private void dfs(Deque<Integer> cur, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(cur, i + 1);
            cur.removeLast();
        }
    }
}
