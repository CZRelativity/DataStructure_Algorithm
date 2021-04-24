package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class convertBST538 {
    public static void main(String[] args) {
        convertBST538 t = new convertBST538();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8},
                {0, null, 1}, {1, 0, 2}, {3, 2, 4, 1}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            TreeNodeTool.outBfBt(convertBST(root));
        }
    }

    List<TreeNode> orderList;

    //85%
    public TreeNode convertBST(TreeNode root) {
        orderList = new ArrayList<>();
        inOrder(root);
        for (int i = orderList.size() - 2; i >= 0; i--) {
            orderList.get(i).val += orderList.get(i + 1).val;
        }
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        orderList.add(root);
        inOrder(root.right);
    }
}
