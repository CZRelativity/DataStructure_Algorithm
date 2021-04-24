package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class flatten114 {
    public static void main(String[] args) {
        flatten114 t = new flatten114();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{}, {1, 2, 5, 3, 4, null, 6}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            flattenRecursion(root);
            TreeNodeTool.outBfBt(root);
        }
    }

    //100%，思路：将左子树插入到右子树的地方，再把原右子树插入到最右结点
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode rightChild = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode temp = root.right;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = rightChild;
            }
            root = root.right;
        }
    }

    TreeNode pre = null;

    /* 前序遍历的顺序是123456 如果我们每遍历到一个结点就设为前一个结点的右结点就好了，
    但是这样就会失去原来的右子树导致没有办法再继续遍历了 解决的方法是先遍历到6
     利用一个全局变量来存放前结点*/
    public void flattenRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenRecursion(root.right);
        flattenRecursion(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
