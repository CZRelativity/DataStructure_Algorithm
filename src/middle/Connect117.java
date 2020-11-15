package middle;

public class Connect117 {
    public static void main(String[] args) {

    }

    private void test(){
        Integer[][] eg={{1,2,3,4,5,null,7},{}};
        for(Integer[] e:eg){

        }
    }

    public Node connect(Node root) {
        df(root);
        return root;
    }

    private void df(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        df(root.left);
        df(root.right);
    }

    private class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }
    }
}
