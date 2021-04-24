package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class pathSum437 {
    public static void main(String[] args) {
        pathSum437 t = new pathSum437();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, {1, null, 2, null, 3, null, 4, null, 5},};
        int[] egSum = {8, 3};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            System.out.println(pathSum(root, egSum[i]));
        }
    }

    int path;

    //64%
    public int pathSum(TreeNode root, int sum) {
        path = 0;
        dfs0(root, sum);
        return path;
    }

    private void dfs0(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        dfs(root, 0, sum);
        dfs0(root.left, sum);
        dfs0(root.right, sum);
    }

    private void dfs(TreeNode root, int curSum, int targetSum) {
        curSum += root.val;
        if (curSum == targetSum) {
            path++;
        }
        if (root.left != null) {
            dfs(root.left, curSum, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, curSum, targetSum);
        }
    }
}
