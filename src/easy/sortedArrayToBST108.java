package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class sortedArrayToBST108 {
    public static void main(String[] args) {
        sortedArrayToBST108 t = new sortedArrayToBST108();
        t.test();
    }

    private void test() {
        int[][] eg = {{-10, -3, 0, 5, 9}, {}};
        for (int[] e : eg) {
            TreeNodeTool.outBfBt(sortedArrayToBST(e));
        }
    }

    //实际上是高度平衡二叉树AVL树
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    //100% 好家伙
    private TreeNode toBST(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        //向上取整保证不会漏点，或者from+(from+to)/2 啊这?
        int mid = (int) Math.ceil(((double) from + (double) to) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        //保证left结点在mid左
        root.left = toBST(nums, from, mid - 1);
        //保证right结点在mid右
        root.right = toBST(nums, mid + 1, to);
        return root;
    }
}
