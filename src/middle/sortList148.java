package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class sortList148 {
    public static void main(String[] args) {
        sortList148 t = new sortList148();
        t.test();
    }

    private void test() {
        int[][] eg = {{4, 2, 1, 3}, {-1, 5, 3, 4, 0}};
        for (int[] e : eg) {
            ListNodeTool.outputList(sortListIteration(ListNodeTool.buildList(e)));
        }
    }

    public ListNode sortListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] divide = divideList(head);
        ListNode h1 = sortListRecursion(divide[0]);
        ListNode h2 = sortListRecursion(divide[1]);
        return mergeList(h1, h2);
    }

    public ListNode sortListIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre, cur;
        int len = getLen(head);
        for (int step = 1; step < len; step *= 2) {
            pre = tempHead;
            cur = tempHead.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = splitList(h1, step);
                cur = splitList(h2, step);
                pre.next = mergeList(h1, h2);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return tempHead.next;
    }

    private int getLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    //分
    private ListNode[] divideList(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return new ListNode[]{head, slow};
    }

    private ListNode splitList(ListNode head, int pos) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead, cur = head;
        while (pos > 0 && cur != null) {
            pre = pre.next;
            cur = cur.next;
            pos--;
        }
        pre.next = null;
        return cur;
    }

    //合
    private ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    temp.next = h1;
                    h1 = h1.next;
                } else {
                    temp.next = h2;
                    h2 = h2.next;
                }
            } else if (h1 != null) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        return tempHead.next;
    }
}
