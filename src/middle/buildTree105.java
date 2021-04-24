package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

class buildTree105 {
    public static void main(String[] args) {
        buildTree105 t = new buildTree105();
        t.test();
    }

    private void test() {
        int[][] egPre = {{3, 9, 20, 15, 7},{}};
        int[][] egIn = {{9, 3, 15, 20, 7},{}};
        for (int i = 0; i < egPre.length; i++) {
            TreeNode root = buildTree(egPre[i], egIn[i]);
            TreeNodeTool.outBfBt(root);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return df(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode df(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }
        int leftLen = i - 1 - inStart + 1;
        root.left = df(pre, in, preStart + 1, preStart + leftLen, inStart, i - 1);
        root.right = df(pre, in, preStart + leftLen + 1, preEnd, i + 1, inEnd);
        return root;
    }
}
