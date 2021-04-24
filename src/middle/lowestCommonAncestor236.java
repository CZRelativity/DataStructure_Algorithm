package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class lowestCommonAncestor236 {
    public static void main(String[] args) {
        lowestCommonAncestor236 t = new lowestCommonAncestor236();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}};
        int[][] egT = {{5, 1}, {5, 4}};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            TreeNode p = TreeNodeTool.getNodeByVal(root, egT[i][0]);
            TreeNode q = TreeNodeTool.getNodeByVal(root, egT[i][1]);
            TreeNode ancestor = lowestCommonAncestor(root, p, q);
            System.out.println(ancestor.val);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /* 如果left和right都为空，说明p q都不在左右子树中，返回null */
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        /* 如果都不为空，说明pq在root结点的异侧，此时root是pq祖先结点，返回 */
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //找到p或者找到q
        if (root == null || root == p || root == q) {
            return root;
        }
        //左右分别找，p就是q的祖先的情况，也会返回p的
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        //下面两个if是为了任何一边找到以后一定可以返回到顶端
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //p，q都找到了，返回最近祖先root
        return root;
    }
}
