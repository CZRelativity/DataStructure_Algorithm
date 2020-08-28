package data_structure;

import java.util.Arrays;
import java.util.Random;

public class AVLTree {

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        int[] example = new int[]{4, 3, 6, 5, 7, 8};
        int[] test=new int[]{10,7,8};
        int[] randArr = new int[1000];
        int[] error1=new int[]{8, 0, 9, 3, 4, 0, 2, 4, 7, 7};
        int[] error2=new int[]{7, 1, 8, 6, 3, 5, 6, 4, 6, 2};
        Random r = new Random();
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = r.nextInt(1000);
        }
        System.out.println(Arrays.toString(randArr));
        t.formAVLTree(randArr);
        System.out.println(t.root.getLeftHeight());
        System.out.println(t.root.getRightHeight());
    }

    private SimpleNode root;

    public void inOrderList(SimpleNode node) {
        if (node.left != null) {
            inOrderList(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrderList(node.right);
        }
    }

    public void formAVLTree(int[] arr) {
        root = null;
        for (int i : arr) {
            add(new SimpleNode(i));
        }
    }


    public void add(SimpleNode node) {
        if (root == null) {
            root = node;
            return;
        }
        SimpleNode temp = root;
        while (true) {
            if (node.data < temp.data) {
                if (temp.left == null) {
                    temp.left = node;
                    //当插入后leftHeight-rightHeight>1,就不再满足AVL树的平衡条件了，
                    //因为这时呈左偏了，需要向右旋转，
                    //但在这之前还要先判断是不是要双旋转
                    if (root.getLeftHeight() - root.getRightHeight() > 1) {
                        //如果左结点的右子树高度大于左子树，则需要先从左结点左旋，使左高度+1，右高度-1
                        //否则整体右旋使左高度-1，右高度+1+1（原左结点右子树比左子树高1），就又偏右了
                        if (root.left!=null&&
                                root.left.getRightHeight() > root.left.getLeftHeight()) {
                            root.left.leftRotate();
                        }
                        root.rightRotate();
                    }
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    //当插入以后rightHeight-leftHeight>1，不再满足AVL树的平衡条件了，
                    //这时右偏了，需要向左旋转
                    //但在之前要先判断是不是要双旋转
                    if (root.getRightHeight() - root.getLeftHeight() > 1) {
                        //如果右节点的左子树高度大于右子树，则需要从右节点先右旋，使左高度-1，右高度+1
                        //否则整体左旋使左高度+1+1(原右节点左子树比右子树高1)，右高度-1，就又左偏了
                        if (root.right!=null&&
                                root.right.getLeftHeight() > root.right.getRightHeight()) {
                            root.right.rightRotate();
                        }
                        root.leftRotate();
                    }
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    static class SimpleNode {
        int data;
        SimpleNode left;
        SimpleNode right;

        public SimpleNode(int data) {
            this.data = data;
        }

        public int height() {
            //理解一下这个递归，
            int h = Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
            return h;
        }

        public int getLeftHeight() {
            return left == null ? 0 : left.height();
        }

        public int getRightHeight() {
            return right == null ? 0 : right.height();
        }

        //由于双旋转的需求，需要能从任意结点旋转
        public void leftRotate() {
            //这个只有画个图跟着想象
            //用原根结点的值创建一个新结点，作为新根的左子树
            SimpleNode newNode = new SimpleNode(data);
            //把新结点的左子树设置成原根结点的左子树
            newNode.left = left;
            //新结点的右子树是原根结点的右子树的左子树
            newNode.right = right.left;
            //原根的右结点的值现在放到根节点
            data = right.data;
            //原根的左子树现在设成新结点
            left = newNode;
            //根的右子树现在是原来右子树的右子树
            right = right.right;
            //原来的右节点至此完全失去引用，被自动销毁
            //总结一下，原右结点成根，原根成左结点，新左结点左子树不变（小于左结点）
            //右子树是原右结点（新根）的左子树（大于左结点并小于根结点）
            //新根的右子树不变（原右结点的右子树，大于新根结点）
        }

        public void rightRotate() {
            SimpleNode newNode = new SimpleNode(data);
            //新结点的右指向原根的右子树
            newNode.right = right;
            //新结点的左指向原根左子树的右子树（小于原根又大于原根左结点）
            newNode.left = left.right;
            //原根的值改为左结点值（准备丢弃原左结点）
            data = left.data;
            //右节点指向新结点
            right = newNode;
            //最后跳过原左结点，使其被销毁
            left = left.left;
        }
    }
}
