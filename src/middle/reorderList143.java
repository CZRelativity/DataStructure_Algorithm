package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.Stack;

public class reorderList143 {
    public static void main(String[] args) {
        reorderList143 t = new reorderList143();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4,}, {1, 2, 3, 4, 5,}, {}, {1, 2,}, {1, 2, 3,}};
        for (int[] e : eg) {
            ListNode head = ListNodeTool.buildList(e);
            reorderList1(head);
            ListNodeTool.outputList(head);
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode temp = head;
        //还是算线性复杂度吧？
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.next;
        }
        temp = head;
        //退出条件，栈顶指向指针结点
        while (!nodeStack.peek().equals(temp.next)
                && !nodeStack.peek().equals(temp)) {
            ListNode insert = nodeStack.pop();
            insert.next = temp.next;
            temp.next = insert;
            temp = temp.next.next;
        }
        if (nodeStack.peek().equals(temp)) {
            temp.next = null;
        } else {
            temp.next.next = null;
        }
    }

    public void reorderList1(ListNode head){

    }
}
