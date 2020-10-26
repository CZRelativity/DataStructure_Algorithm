package dataStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        SimpleNode root=t.buildOrderBinaryTree(new int[]{1,2,3,4,5,6,7},0);
//        SimpleNode root = t.buildOnPreAndInOrderArr(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}, 0, 4, 0, 4);
//        t.preOrderList(root);
//        System.out.println();
//        t.inOrderList(root);
//        System.out.println();
//        t.inOrderLiterateList(root);
//        System.out.println();
//        t.postOrderList(root);
//        System.out.println();
//        t.postOrderDelete(root,3);
        t.bfList(root);
    }

    //前序中序后序遍历
    void preOrderList(SimpleNode root) {
        System.out.print(root.id + " ");
        if (root.left != null) {
            preOrderList(root.left);
        }
        if (root.right != null) {
            preOrderList(root.right);
        }
    }

    void inOrderList(SimpleNode root) {
        if (root.left != null) {
            inOrderList(root.left);
        }
        System.out.print(root.id + " ");
        if (root.right != null) {
            inOrderList(root.right);
        }
    }

    void inOrderLiterateList(SimpleNode root){
        if(root==null) {
            return;
        }
        Stack<SimpleNode> nodeStack=new Stack<>();
        SimpleNode temp=root;
        //首次和右结点存在的情况下，符合条件1，右结点不存在的情况下符合条件2，栈底开始为根结点
        while(temp!=null||!nodeStack.empty()){
            //左结点存在的情况下会一直查找到底，符合中序遍历的顺序，使用栈结构，符合先进后出
            while(temp!=null){
                nodeStack.push(temp);
                temp=temp.left;
            }
            //弹出栈顶，检查最左结点的右结点，进入下一次循环
            if(!nodeStack.empty()){
                temp=nodeStack.pop();
                System.out.print(temp.id+" ");
                temp=temp.right;
            }
        }
    }

    void postOrderList(SimpleNode root) {
        if (root.left != null) {
            postOrderList(root.left);
        }
        if (root.right != null) {
            postOrderList(root.right);
        }
        System.out.print(root.id + " ");
    }

    /**树的层序遍历（树的广度优先遍历），用队列，就这么愉快
     * @param root 根结点
     */
    void bfList(SimpleNode root){
        Queue<SimpleNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            SimpleNode node=queue.remove();
            System.out.print(node.id+" ");
            //最好不要往队列中插入null，虽然在元素上不会有影响，但是会影响到size的计算
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //前序中序后序查找

    SimpleNode inOrderSearch(SimpleNode node, int find) {
        if (node.left != null) {
            inOrderSearch(node.left, find);
        }
        if (node.id == find) {
            return node;
        }
        if (node.right != null) {
            inOrderSearch(node.right, find);
        }
        return null;
    }

    //改、删
    //如果只有一个子结点， 就用子结点代替；如果有两个子结点，就用左子结点代替
    void postOrderDelete(SimpleNode node, int id) {
        if (node.left.id == id) {
            if (node.left.left == null && node.left.right != null) {
                node.left = node.left.right;
            } else {
                node.left = node.left.left;
            }
            return;
        } else if (node.right.id == id) {
            if (node.right.left == null && node.right.right != null) {
                node.right = node.right.right;
            } else {
                node.right = node.right.left;
            }
            return;
        }
        if (node.left != null) {
            postOrderDelete(node.left, id);
        }
        if (node.right != null) {
            postOrderDelete(node.right, id);
        }
    }

//    void inOrderThread(SimpleNode pre,SimpleNode current){
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
    SimpleNode buildOrderBinaryTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        SimpleNode root = new SimpleNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBinaryTree(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBinaryTree(arr, 2 * index + 2);
        }
        return root;
    }

    SimpleNode buildOnPreAndInOrderArr(int[] pre, int[] in, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex == preEndIndex) {
            return new SimpleNode(pre[preStartIndex]);
        }
        SimpleNode root = null;
        int i = inStartIndex;
        //第一次时在这里的 <= 犯错了
        for (; i <= inEndIndex; i++) {
            if (in[i] == pre[preStartIndex]) {
                root = new SimpleNode(in[i]);
                break;
            }
        }
        //为了便于理解,按endIndex-startIndex+1来写
        int leftLength=i-1-inStartIndex+1;
        if (root != null) {
            /*左子树：
            * preStartIndex 原前序的起始位置已经生成了这个root，前序起始索引+1
            * preEndIndex 新的起始Index+划分出来的左半in数组长度leftLength得到pre数组中下半部分的起点，再-1得到这部分的终点
            * 以i划分的左半in数组，索引是原in起点到i的左边为止
            */
            root.left = buildOnPreAndInOrderArr(pre, in, preStartIndex + 1,
                    preStartIndex+leftLength, inStartIndex, i - 1);
            /*右子树:
            * preStartIndex 左子树preEndIndex+1
            * */
            root.right = buildOnPreAndInOrderArr(pre, in, preStartIndex+leftLength+1,
                    preEndIndex, i + 1, inEndIndex);
        }
        return root;
    }

    class SimpleNode {
        int id;
        SimpleNode left;
        SimpleNode right;
//        boolean isLeftToPre;
//        boolean isRightToNext;

        public SimpleNode(int id) {
            this.id = id;
//            this.isLeftToPre=false;
//            this.isRightToNext=false;
        }
    }
}
