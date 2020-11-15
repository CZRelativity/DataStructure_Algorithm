package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric101 {
    public static void main(String[] args) {
        isSymmetric101 t = new isSymmetric101();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, 2, 2, 3, 4, 4, 3}, {1, 2, 2, null, 3, null, 3},
                {4, -57, -57, null, 67, 67, null, null, -97, -97}, {2, 3, 3, 4, 5, null, 4}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBt(e);
            TreeNodeTool.outBfBt(root);
            System.out.println(isSymmetricBf(root));
        }
    }

    public boolean isSymmetricBf(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        //改递归
        return isLevelSymmetric(queue1, queue2);
//        while(!queue1.isEmpty()||!queue2.isEmpty()){
//            if(queue1.isEmpty()){
//                if(isLevelNotSymmetric(queue2, queue1)){
//                    return false;
//                }
//            }else {
//                if(isLevelNotSymmetric(queue1, queue2)){
//                    return false;
//                }
//            }
//        }
//        return true;
    }

    //广度优先/层序搜索 28% - -
    public boolean isLevelSymmetric(Queue<TreeNode> queue, Queue<TreeNode> nextQueue) {
        //用str感觉被负号制裁了呀
//        StringBuilder valStr=new StringBuilder();

        if (queue.isEmpty()) {
            return true;
        }

        int[] val = new int[queue.size() * 2];
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            if (curNode.left != null) {
                val[i++] = curNode.left.val;
                nextQueue.add(curNode.left);
            } else {
                val[i++] = Integer.MIN_VALUE;
            }
            if (curNode.right != null) {
                val[i++] = curNode.right.val;
                nextQueue.add(curNode.right);
            } else {
                val[i++] = Integer.MIN_VALUE;
            }
        }
        //new StringBuilder.toString()可替换为String.valueOf(StringBuilder)

        //改一行
        return isValSymmetric(val) && isLevelSymmetric(nextQueue, queue);
    }

    public boolean isValSymmetric(int[] val) {
        int left = 0, right = val.length - 1;
        while (left < right) {
            if (val[left] != val[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //对称就是镜像等于本身,但不是.equals哈,深度优先遍历方法？
    public boolean isSymmetricDf(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isNodeSymmetric(root, root);
    }

    public boolean isNodeSymmetric(TreeNode root, TreeNode mirror) {

        if (root == null && mirror == null) {
            return true;
        }
        if (root == null || mirror == null) {
            return false;
        }
        //大神的一行
        return root.val == mirror.val &&
                isNodeSymmetric(root.left, mirror.right) &&
                isNodeSymmetric(root.right, mirror.left);
    }

}
