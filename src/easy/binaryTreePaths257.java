package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths257 {
    public static void main(String[] args) {
        binaryTreePaths257 t = new binaryTreePaths257();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{3, 1, 4, null, 2}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            binaryTreePaths(root);
            System.out.println(res);
        }
    }

    List<String> res;

    //时间84%
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(new StringBuilder(), root);
        return res;
    }

    private void dfs(StringBuilder path, TreeNode root) {
        path.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.substring(2));
            return;
        }
        //不能用root==null做退出条件，否则left==null right==null会加入两次相同路径
        if (root.left != null) {
            dfs(new StringBuilder(path), root.left);
        }
        if (root.right != null) {
            dfs(new StringBuilder(path), root.right);
        }
    }
}
