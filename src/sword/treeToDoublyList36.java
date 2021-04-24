package sword;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.*;

class treeToDoublyList36 {
    public static void main(String[] args) {
        treeToDoublyList36 t = new treeToDoublyList36();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{}, {1}, {4, 2, 5, 1, 3}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.buildOrderBT(e);
            TreeNode head = tree2DoublyList(root);
            for (int i = 0; i < e.length; i++) {
                System.out.print(head.val + " ");
                head = head.right;
            }
            for (int i = 0; i < e.length; i++) {
                System.out.print(head.val + " ");
                head = head.left;
            }
            System.out.println();
        }
    }

    //借了一个List虽然很方便但是好像可以用递归
    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp);
            temp = temp.right;
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            TreeNode next;
            if (i == list.size() - 1) {
                next = list.get(0);
            } else {
                next = list.get(i + 1);
            }
            cur.right = next;
            next.left = cur;
        }
        return list.get(0);
    }

    TreeNode pre;
    TreeNode head;

    //100%
    public TreeNode tree2DoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        pre = null;
        head = null;
        dfs(root);
        //之后只需连接尾头
        pre.right = head;
        head.left = pre;
        return head;
    }

    //中序遍历结束的时候pre正好是我们想要的尾结点
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        /* 没有pre的时候无法连接，
        其实也只有第一次，即中序的首结点，
        正是我们想要的头结点 */
        if (pre == null) {
            head = root;
        } else {
            /* 题目规定了连接的方式，
            其实已经不用考虑本身的连接 */
            pre.right = root;
            root.left = pre;
        }
        //每次的相同点是都要更新pre结点
        pre = root;
        dfs(root.right);
    }
}
