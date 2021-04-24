package sword;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;

public class pathSum34 {
    public static void main(String[] args) {
        pathSum34 t = new pathSum34();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, 2,}, {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}};
        int[] sum = {1, 22,};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            List<List<Integer>> ret = pathSum(root, sum[i]);
            ret.forEach(System.out::println);
        }
    }

    List<List<Integer>> ret;

    //100%
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        dfs(root, new ArrayList<>(), 0, sum);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> path, int curSum, int sum) {
        /*
        要求的路径必须是从根结点到叶子结点的路径，而且不能root==null的时候判定，会导致重复
        */
        curSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && curSum == sum) {
//            一直用同一个list，至少在最后加入的时候回溯，否则最后结果里面只有一个list的地址
            ret.add(new ArrayList<>(path));
            //且加完以后一样要removeLast，否则少一次remove会影响到后面的路径
        }
        if (root.left != null) {
            dfs(root.left, path, curSum, sum);
        }
        if (root.right != null) {
            dfs(root.right, path, curSum, sum);
        }
        path.remove(path.size() - 1);
    }
}
