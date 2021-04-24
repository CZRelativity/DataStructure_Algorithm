package middle;

import java.util.*;

public class subsetsWithDup90 {
    public static void main(String[] args) {
        subsetsWithDup90 t = new subsetsWithDup90();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 2}, {4, 4, 4, 1, 4}};
        for (int[] e : eg) {
            subsetsWithDup(e);
            res.forEach(System.out::println);
        }
    }

    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];
        //细节：按照前后相等去重必须先排序！
        Arrays.sort(nums);
        dfs(new LinkedList<>(), nums, 0);
        return res;
    }

    private void dfs(Deque<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                /* 去重仍然有效，因为是按照for循环顺序来的，
                前一个相同的数没有用过反而是前一个数用过以后回溯的标志 */
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                dfs(cur, nums, i + 1);
                cur.removeLast();
                used[i] = false;
            }
        }
    }
}
