package middle;

import java.util.ArrayList;
import java.util.List;

public class permute46 {
    public static void main(String[] args) {
        permute46 t = new permute46();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3}, {1}, {}};
        for (int[] e : eg) {
            permute(e);
            res.forEach(System.out::println);
        }
    }

    boolean[] used;
    List<List<Integer>> res;
    int len;

    //99%
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        used = new boolean[len];
        res = new ArrayList<>();
        onPermute(nums, new ArrayList<>());
        return res;
    }

    private void onPermute(int[] nums, List<Integer> cur) {
        if (cur.size() == len) {
            //只在添加的时候拷贝，减少拷贝次数
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                onPermute(nums, cur);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
