package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class isValidBST98 {
    public static void main(String[] args) {
        isValidBST98 t = new isValidBST98();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{2, 1, 3}, {5, 1, 4, null, null, 3, 6}, {10, 5, 15, null, null, 6, 20}, {1, 1}, {-2147483648}};
        for (Integer[] e : eg) {
            System.out.println(isValid1(TreeNodeTool.buildOrderBT(e)));
        }
    }

    //以最最小值作为递归的起始值
    private long preVal = Long.MIN_VALUE;
    //中序递归一定是从最左最小开始按顺序修改preVal的，将preVal定义成对象属性不用传值

    /**
     * 不是左右结点满足就可以了，要左右子树都满足
     * 一定要留意BST的性质：中序遍历时应该是一个有序数组！
     *
     * @param root 根结点
     * @return 是否有效的二叉搜索树
     */
    public boolean isValid(TreeNode root) {
        //在递归一开始设置退出条件null，这样在主程序开头不用判断，在后面左右结点时也不用判断
        if (root == null) {
            return true;
        }
        //返回boolean的递归一定要写在if条件里
        if (!isValid(root.left)) {
            return false;
        }

        if (preVal < root.val) {
            preVal = root.val;
        } else {
            return false;
        }
        //中序
        return isValid(root.right);
    }

    public boolean isValid1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //忘了返回boolean的中序要怎么写？
        if (!isValid1(root.left)) {
            return false;
        }
        //题目要求左结点严格小于，右结点严格大于
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        return isValid1(root.right);
    }
}
