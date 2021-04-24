package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.HashMap;

public class rob337 {
    public static void main(String[] args) {
        rob337 t = new rob337();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{2, 1, 3, null, 4}, {4, 1, null, 2, null, 3}, {3, 2, 3, null, 3, null, 1}, {3, 4, 5, 1, 3, null, 1}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            System.out.println(rob(root));
        }
    }

//    int[] levelSum;
//
//    public int rob(TreeNode root) {
//        levelSum = new int[10];
//        dfs(root, 0);
//        int[] dp = new int[levelSum.length];
//        dp[0] = levelSum[0];
//        dp[1] = Math.max(dp[0], levelSum[1]);
//        for (int i = 2; i < dp.length; i++) {
//            if (levelSum[i] == 0) {
//                return dp[i - 1];
//            }
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + levelSum[i]);
//        }
//        return dp[dp.length - 1];
//    }
//
//    //其实完全是个层序，妈的，结果还可以跳两层 gg了
//    private void dfs(TreeNode node, int level) {
//        if (node == null) {
//            return;
//        }
//        if (level == levelSum.length) {
//            levelSum = Arrays.copyOf(levelSum, levelSum.length + 10);
//        }
//        levelSum[level] += node.val;
//        dfs(node.left, level + 1);
//        dfs(node.right, level + 1);
//    }

    HashMap<TreeNode, Integer> memorial;

    public int rob(TreeNode root) {
        memorial = new HashMap<>();
        return dfs(root);
    }

    //59%，dfs+dp+记忆化
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memorial.containsKey(root)) {
            return memorial.get(root);
        }
        /* 对每一个根结点来说
        1、偷根结点跟所有孙子结点
         2、偷两个孩子结点
         深搜递归式成了我们的动态规划的状态表达式*/
         int grandchildren = root.val;
        int children = 0;
        if (root.left != null) {
            children += dfs(root.left);
            grandchildren += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            children += dfs(root.right);
            grandchildren += dfs(root.right.left) + dfs(root.right.right);
        }
        int ret = Math.max(grandchildren, children);
        memorial.put(root, ret);
        return ret;
    }
}
