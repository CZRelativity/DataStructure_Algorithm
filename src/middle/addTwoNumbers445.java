package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.*;

class addTwoNumbers445 {
    public static void main(String[] args) {
        addTwoNumbers445 t = new addTwoNumbers445();
        t.test();
    }

    private void test() {
        int[][] eg1 = {{7, 2, 4, 3}};
        int[][] eg2 = {{5, 6, 4}};
        for (int i = 0; i < eg1.length; i++) {
            ListNode head = addTwoNumbers(ListNodeTool.buildList(eg1[i]), ListNodeTool.buildList(eg2[i]));
            ListNodeTool.outputList(head);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int len1 = 0;
        int len2 = 0;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        int[] calculate = new int[Math.max(len1, len2) + 1];
        int pos = 1;
        p1 = l1;
        p2 = l2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                calculate[pos] = p1.val;
                p1 = p1.next;
                pos++;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                calculate[pos] = p2.val;
                p2 = p2.next;
                pos++;
            }
        }
        while (p1 != null) {
            calculate[pos] = p1.val + p2.val;
            pos++;
            p1 = p1.next;
            p2 = p2.next;
        }
        for (int i = calculate.length - 1; i > 0; i--) {
            if (calculate[i] >= 10) {
                calculate[i] = calculate[i] % 10;
                calculate[i - 1]++;
            }
        }
        ListNode tempHead = new ListNode(-1);
        ListNode temp = tempHead;
        if (calculate[0] == 1) {
            temp.next = new ListNode(1);
            temp = temp.next;
        }
        for (int i = 1; i < calculate.length; i++) {
            temp.next = new ListNode(calculate[i]);
            temp = temp.next;
        }
        return tempHead.next;
    }
}
