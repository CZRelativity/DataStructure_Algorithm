package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class diameterOfBinaryTree543 {
    public static void main(String[] args) {
        diameterOfBinaryTree543 t = new diameterOfBinaryTree543();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{}, {1}, {1, 2, 3, 4, 5}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            System.out.println(diameterOfBinaryTree(root));
        }
    }

    int max;

    //100%
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        diameter(root);
        return max - 1;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = diameter(root.left);
        int r = diameter(root.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
