package Easy;

import Tools.ListNode;

public class merge_list {
    public ListNode Merge_Original(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode end = head;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l1 != null && l2 != null && l2.val <= l1.val)) {
                end.next = new ListNode(l2.val);
                end = end.next;
                l2 = l2.next;
            } else {
                end.next = new ListNode(l1.val);
                end = end.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }
}
