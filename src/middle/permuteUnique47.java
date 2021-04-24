package middle;

import java.util.*;

public class permuteUnique47 {
    public static void main(String[] args) {
        permuteUnique47 t = new permuteUnique47();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 1, 2}, {1, 2, 3}};
        for (int[] e : eg) {
            permuteUnique(e);
            res.forEach(System.out::println);
        }
    }

    boolean[] used;
    List<List<Integer>> res;
    int len;

    //66%
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        used = new boolean[len];
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, Deque<Integer> cur) {
        if (cur.size() == len) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            //对后一个的相同元素来说，前一个相同的元素未使用过反而是前一个相同元素已经使用过然后回溯了的标志
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            dfs(nums, cur);
            cur.removeLast();
            used[i] = false;
        }
    }
}
