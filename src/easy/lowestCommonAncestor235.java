package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lowestCommonAncestor235 {
    public static void main(String[] args) {
        lowestCommonAncestor235 t = new lowestCommonAncestor235();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, {3, 1, 4, null, 2}};
        int[][] egT = {{2, 4,}, {2, 3,}};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            TreeNode p = TreeNodeTool.getNodeByVal(root, egT[i][0]);
            TreeNode q = TreeNodeTool.getNodeByVal(root, egT[i][1]);
            TreeNode father = lowestCommonAncestor2(root, p, q);
            System.out.println(father.val);
        }
    }

    Deque<TreeNode> path;
//    TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path = new LinkedList<>();
        dfs(new LinkedList<>(), root, p);
        List<TreeNode> path1 = new ArrayList<>(path);
        path = new LinkedList<>();
        dfs(new LinkedList<>(), root, q);
        List<TreeNode> path2 = new ArrayList<>(path);
        TreeNode ancestor = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                ancestor = path1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private void dfs(Deque<TreeNode> q, TreeNode root, TreeNode target) {
        q.add(root);
        if (root == target) {
            path.addAll(q);
            return;
        }
        if (path.size() == 0 && root.left != null) {
            dfs(q, root.left, target);
        }
        if (path.size() == 0 && root.right != null) {
            dfs(q, root.right, target);
        }
        q.removeLast();
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            //二叉搜索树，向左一定是变小
            return lowestCommonAncestor2(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            //向右一定是变大
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
}
