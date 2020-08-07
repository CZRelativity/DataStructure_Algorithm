package Data_Structure;

public class ThreadBinaryTree {

    public static void main(String[] args) {
        ThreadBinaryTree t = new ThreadBinaryTree();
        t.inOrderList(t.root);
        System.out.println();
        t.inOrderThread(t.root);
        t.inOrderThreadList();
    }

    private SimpleNode pre;
    private SimpleNode root;

    SimpleNode forThread() {
        SimpleNode root = new SimpleNode(1);
        root.left = new SimpleNode(3);
        root.right = new SimpleNode(6);
        root.left.left = new SimpleNode(8);
        root.left.right = new SimpleNode(10);
        root.right.left = new SimpleNode(14);
        return root;
    }

    public ThreadBinaryTree() {
        this.pre = null;
        this.root = forThread();
    }

    void inOrderThreadList() {
        SimpleNode temp = root;
        while (temp != null) {
            while (!temp.isLeftToPre) {
                temp = temp.left;
            }
            //一直找，找到被线索化处理的第一个节点，其实也是没有左子节点的第一个节点，打印
            System.out.print(temp.id + " ");
            //打印以后，如果这个节点的右子节点被线索化指向下一个节点的话就一直打印并跳到下一个
            while (temp.isRightToNext) {
                temp = temp.right;
                System.out.print(temp.id + " ");
            }
            //直到节点没被线索化了
            //中序遍历，这里开始向右
            temp = temp.right;
        }
    }

    void inOrderList(SimpleNode node) {
        if (node.left != null) {
            inOrderList(node.left);
        }
        System.out.print(node.id + " ");
        if (node.right != null) {
            inOrderList(node.right);
        }
    }

    void inOrderThread(SimpleNode node) {
        if (node == null) {
            return;
        }
        inOrderThread(node.left);
        if (node.left == null) {
            node.left = pre;
            node.isLeftToPre = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.isRightToNext = true;
        }
        pre = node;
        //pre节点与之后节点的关系是没有限制的
        inOrderThread(node.right);
    }

    class SimpleNode {
        int id;
        SimpleNode left;
        SimpleNode right;
        boolean isLeftToPre;
        boolean isRightToNext;

        public SimpleNode(int id) {
            this.id = id;
            this.isLeftToPre = false;
            this.isRightToNext = false;
        }
    }
}
