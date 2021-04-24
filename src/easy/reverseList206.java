package easy;

import tools.ListNode;
import tools.ListNodeTool;

class reverseList206 {
    public static void main(String[] args) {
        reverseList206 t = new reverseList206();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4, 5},};
        for (int[] e : eg) {
            ListNodeTool.outputList(reverseListIteration(ListNodeTool.buildList(e)));
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseListIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode tempHead = new ListNode(-1);
//        Stack<ListNode> nodeStack = new Stack<>();
//        while (head != null) {
//            nodeStack.push(head);
//            head = head.next;
//        }
//        ListNode temp = tempHead;
//        while (!nodeStack.isEmpty()) {
//            temp.next = nodeStack.pop();
//            temp = temp.next;
//        }
//        temp.next = null;
//        return tempHead.next;
        ListNode cur = head;
        ListNode next;
        ListNode tempHead = new ListNode(-1);
        while (cur != null) {
            next = cur.next;
            cur.next = tempHead.next;
            tempHead.next = cur;
            cur = next;
        }
        return tempHead.next;
    }
}
