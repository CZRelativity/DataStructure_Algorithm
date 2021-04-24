package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class invertTree226 {
    public static void main(String[] args) {
        invertTree226 t = new invertTree226();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{4, 2, 7, 1, 3, 6, 9}};
        for (Integer[] e : eg) {
            TreeNode root = invertTree1(TreeNodeTool.buildOrderBT(e));
            TreeNodeTool.outBfBt(root);
        }
    }

    //100%，我居然秒了！
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        /* 以下两句只是为了递归查找到最下层非叶子结点，也可以说是左右子树都翻转了，后序 */
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        //从最下层非叶子结点开始交换左右
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    //结果迭代是写广搜最简单啊！
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur.left != null || cur.right != null) {
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        invertTree2(root.left);
        invertTree2(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
