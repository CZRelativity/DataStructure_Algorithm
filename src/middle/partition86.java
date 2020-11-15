package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class partition86 {
    public static void main(String[] args) {
        partition86 t = new partition86();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 4, 3, 2, 5, 2}, {1, 1, 1, 1, 1,}, {}};
        int[] egX = {3, 2};
        for (int i = 0; i < eg.length; i++) {
            ListNode head = ListNodeTool.buildList(eg[i]);
            ListNode res = partition(head, egX[i]);
            ListNodeTool.outputList(res);
        }
    }

    //100%
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        //双假头
        ListNode lessHead = new ListNode(0);
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode lessNode = lessHead;
        ListNode cur = tempHead;

        while (cur.next != null) {
            if (cur.next.val < x) {
                lessNode.next = cur.next;
                lessNode = lessNode.next;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        lessNode.next = tempHead.next;
        return lessHead.next;
    }
}
