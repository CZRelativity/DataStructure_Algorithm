package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class mergeTrees617 {
    public static void main(String[] args) {
        mergeTrees617 t = new mergeTrees617();
        t.test();
    }

    private void test() {
        Integer[][] tree1 = {{1, 3, 2, 5},};
        Integer[][] tree2 = {{2, 1, 3, null, 4, null, 7},};
        for (int i = 0; i < tree1.length; i++) {
            TreeNode t1 = TreeNodeTool.buildOrderBT(tree1[i]);
            TreeNode t2 = TreeNodeTool.buildOrderBT(tree2[i]);
            TreeNodeTool.outBfBt(mergeTrees(t1, t2));
        }
    }

    //用t1存放合并后的树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        //t1!=null&&t2!=null
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
