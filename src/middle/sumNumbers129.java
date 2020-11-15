package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class sumNumbers129 {
    public static void main(String[] args) {
        sumNumbers129 t = new sumNumbers129();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, 2, 3}, {4, 9, 0, 5, 1},{},{1}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBt(e);
            System.out.println(sumNumbers(root));
        }
    }

    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        df(root, 0);
        return sum;
    }

    private void df(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
            return;
        }
        df(root.left, curSum);
        df(root.right, curSum);
    }
}
