package tools;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTool {

    //公式法，递归，但是不适用于有null的情况,因为一个null其实是会打乱下一层的公式计算的
    public static TreeNode buildOrderBt(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBt(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBt(arr, 2 * index + 2);
        }
        return root;
    }

    public static TreeNode buildOrderBt(Integer[] arr) {
        if(arr.length==0){
            return null;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q1.add(root);
        buildLevel(q1, q2, arr, 1, arr.length);
        return root;
    }

    private static void buildLevel(Queue<TreeNode> q, Queue<TreeNode> qNext, Integer[] arr, int i, int l) {
        if (i >= l) {
            return;
        }

        while (!q.isEmpty()) {
            TreeNode curNode = q.remove();
            if (i<l&&arr[i] != null) {
                curNode.left = new TreeNode(arr[i]);
                qNext.add(curNode.left);
            }
            if (i+1<l&&arr[i + 1] != null) {
                curNode.right = new TreeNode(arr[i+1]);
                qNext.add(curNode.right);
            }
            i += 2;
        }

        buildLevel(qNext, q, arr, i, l);
    }

    public static void outBfBt(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);

        //迭代写法
//        while (!queue1.isEmpty()||!queue2.isEmpty()){
//            if(queue1.isEmpty()){
//                outLevel(queue2, queue1);
//            }else {
//                outLevel(queue1, queue2);
//            }
//        }

        //递归写法
        outLevel(queue1, queue2);
        System.out.println();
    }

    private static void outLevel(Queue<TreeNode> queue, Queue<TreeNode> nextQueue) {
        if (queue.isEmpty()) {
            return;
        }
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            System.out.print(curNode.val + " ");
            if (curNode.left != null) {
                nextQueue.add(curNode.left);
            }
            if (curNode.right != null) {
                nextQueue.add(curNode.right);
            }
        }
        outLevel(nextQueue, queue);
    }
}
