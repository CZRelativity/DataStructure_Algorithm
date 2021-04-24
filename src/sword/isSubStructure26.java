package sword;

import tools.TreeNode;
import tools.TreeNodeTool;

public class isSubStructure26 {
    public static void main(String[] args) {
        isSubStructure26 t = new isSubStructure26();
        t.test();
    }

    private void test() {
        Integer[][] egA = {{1, 2, 3}, {3, 4, 5, 1, 2}};
        Integer[][] egB = {{3, 1}, {4, 1}};
        for (int i = 0; i < egA.length; i++) {
            TreeNode A = TreeNodeTool.buildOrderBT(egA[i]);
            TreeNode B = TreeNodeTool.buildOrderBT(egB[i]);
            System.out.println(isSubStructure(A, B));
        }
    }

    //100%，A 任何一个子树满足就可以
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return (A.val == B.val && compare(A, B)) ||
                isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //B，B有结点的时候都必须满足
    private boolean compare(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        return A != null && A.val == B.val
                && compare(A.left, B.left) && compare(A.right, B.right);
    }
}
