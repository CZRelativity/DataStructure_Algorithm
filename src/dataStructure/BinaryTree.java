package dataStructure;

import tools.TreeNode;

import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        TreeNode root = t.buildOrderBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
        t.postOrderIterateList(root);
//        t.bfList(root);
    }

    //前序中序后序遍历
    void preOrderList(TreeNode root) {
        System.out.print(root.val + " ");
        if (root.left != null) {
            preOrderList(root.left);
        }
        if (root.right != null) {
            preOrderList(root.right);
        }
    }

    void preOrderIterateList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            res.add(root.val);
//            stack.push(root);
//            while (root.left != null) {
//                root = root.left;
//                res.add(root.val);
//                stack.push(root);
//            }
//            while (root.right == null && !stack.isEmpty()) {
//                root = stack.pop();
//            }
//            root = root.right;
//        }
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                //前序：1、获取结点值
                res.add(root.val);
                //2、入栈，跳转遍历左子树
                stack.push(root);
                root = root.left;
            } else {
                //3、左子树遍历完成，出栈，跳转遍历右子树
                root = stack.pop();
                root = root.right;
            }
        }
        System.out.println(res);
    }

    void inOrderList(TreeNode root) {
        if (root.left != null) {
            inOrderList(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            inOrderList(root.right);
        }
    }

    void inOrderIterateList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
//        TreeNode temp = root;
//        //首次和右结点存在的情况下，符合条件1，右结点不存在的情况下符合条件2，栈底开始为根结点
//        while (temp != null || !nodeStack.empty()) {
//            //左结点存在的情况下会一直查找到底，符合中序遍历的顺序，使用栈结构，符合先进后出
//            while (temp != null) {
//                nodeStack.push(temp);
//                temp = temp.left;
//            }
//            //弹出栈顶，检查最左结点的右结点，进入下一次循环
//            if (!nodeStack.empty()) {
//                temp = nodeStack.pop();
//                res.add(temp.val);
//                temp = temp.right;
//            }
//        }
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                //中序：1、入栈，跳转遍历左子树
                stack.push(root);
                root = root.left;
            } else {
                //2、左子树遍历完成，出栈，获取结点值
                root = stack.pop();
                res.add(root.val);
                //3、跳转遍历右子树
                root = root.right;
            }
        }
        System.out.println(res);
    }

    void postOrderList(TreeNode root) {
        if (root.left != null) {
            postOrderList(root.left);
        }
        if (root.right != null) {
            postOrderList(root.right);
        }
        System.out.print(root.val + " ");
    }

    void postOrderIterateList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode visited = null;
        while (root != null || !stack.isEmpty()) {
            //后序：1、入栈，跳转遍历左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //3、检查栈顶结点，无右子树或者右子树遍历过，视为遍历完成的根结点，出栈，获取值
            root = stack.peek();
            if (root.right == null || root.right == visited) {
                root = stack.pop();
                res.add(root.val);
                //***
                visited = root;
                root = null;
            } else {
                //2、跳转遍历右子树
                root = root.right;
            }
        }
        System.out.println(res);
    }

    /**
     * 树的层序遍历（树的广度优先遍历），用队列，就这么愉快
     *
     * @param root 根结点
     */
    void bfList(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");
            //最好不要往队列中插入null，虽然在元素上不会有影响，但是会影响到size的计算
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //前序中序后序查找

    TreeNode inOrderSearch(TreeNode node, int find) {
        if (node.left != null) {
            inOrderSearch(node.left, find);
        }
        if (node.val == find) {
            return node;
        }
        if (node.right != null) {
            inOrderSearch(node.right, find);
        }
        return null;
    }

    //改、删
    //如果只有一个子结点， 就用子结点代替；如果有两个子结点，就用左子结点代替
    void postOrderDelete(TreeNode node, int val) {
        if (node.left.val == val) {
            if (node.left.left == null && node.left.right != null) {
                node.left = node.left.right;
            } else {
                node.left = node.left.left;
            }
            return;
        } else if (node.right.val == val) {
            if (node.right.left == null && node.right.right != null) {
                node.right = node.right.right;
            } else {
                node.right = node.right.left;
            }
            return;
        }
        if (node.left != null) {
            postOrderDelete(node.left, val);
        }
        if (node.right != null) {
            postOrderDelete(node.right, val);
        }
    }

//    void inOrderThread(TreeNode pre,TreeNode current){
//        if(current==null){
//            return;
//        }
//        inOrderThread(current,current.left);//问题，限制了pre只能是父节点，实际上不是的
//        if(current.left==null){
//            current.left=pre;
//            current.isLeftToPre=true;
//        }
//        if(pre!=null&&pre.right==null){
//            pre.right=current;
//            pre.isRightToNext=true;
//        }
//        inOrderThread(current,current.right);
//    }

    //这是用顺序存储二叉树的公式来前序递归创建的，否则就需要在数组设空节点，或者是需要两个顺序的遍历数组才能唯一确定一个树
    TreeNode buildOrderBinaryTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBinaryTree(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBinaryTree(arr, 2 * index + 2);
        }
        return root;
    }

    TreeNode buildOnPreAndInOrderArr(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        int i = inStart;
        //第一次时在这里的 <= 犯错了
        for (; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }
        TreeNode root = new TreeNode(in[i]);
        //为了便于理解,按end-start+1来写
        int leftLength = i - 1 - inStart + 1;
        /*左子树：
         * preStart 原前序的起始位置已经生成了这个root，前序起始索引+1
         * preEnd 新的起始Index+划分出来的左半in数组长度leftLength得到pre数组中下半部分的起点，再-1得到这部分的终点
         * 以i划分的左半in数组，索引是原in起点到i的左边为止
         */
        root.left = buildOnPreAndInOrderArr(pre, in, preStart + 1,
                preStart + leftLength, inStart, i - 1);
        /*右子树:
         * preStart 左子树preEnd+1
         * */
        root.right = buildOnPreAndInOrderArr(pre, in, preStart + leftLength + 1,
                preEnd, i + 1, inEnd);

        return root;
    }

}
