package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

class buildTree106 {
    public static void main(String[] args) {
        buildTree106 t = new buildTree106();
        t.test();
    }

    private void test() {
        int[][] egIn = {{1, 2, 3, 4}, {9, 3, 15, 20, 7}};
        int[][] egPost = {{3, 4, 2, 1}, {9, 15, 7, 20, 3}};
        for (int i = 0; i < egIn.length; i++) {
            TreeNode root = buildTree(egIn[i], egPost[i]);
            TreeNodeTool.outBfBt(root);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        if (postStart == postEnd) {
            return new TreeNode(post[postEnd]);
        }
        int i = inStart;
        for (; i < inEnd - inStart + 1; i++) {
            if (in[i] == post[postEnd]) {
                break;
            }
        }
        //endIndex-startIndex+1
        int rightLen = inEnd - (i + 1) + 1;
        TreeNode root = new TreeNode(post[postEnd]);
        root.left = dfs(in, post, inStart, i - 1, postStart, postEnd - 1 - rightLen);
        root.right = dfs(in, post, i + 1, inEnd, postEnd - 1 - rightLen + 1, postEnd - 1);
        return root;
    }
}
