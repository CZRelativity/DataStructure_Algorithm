package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class kthSmallest230 {
    public static void main(String[] args) {
        kthSmallest230 t = new kthSmallest230();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{3, 1, 4, null, 2}, {5, 3, 6, 2, 4, null, null, 1}};
        int[] egK = {1, 3};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            System.out.println(kthSmallest(root, egK[i]));
        }
    }

    int cur;

    //100%
    public int kthSmallest(TreeNode root, int k) {
        cur = 0;
        return dfs(root, k);
    }

    private int dfs(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int ret = dfs(root.left, k);
        if (ret != -1) {
            return ret;
        }
        cur++;
        if (cur == k) {
            return root.val;
        }
        return dfs(root.right, k);
    }
}
