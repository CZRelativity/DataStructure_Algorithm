package easy;

import tools.ListNode;
import tools.ListNodeTool;

public class merge_list {
    public static void main(String[] args) {
        int[] nums1={1,2,4};
        int[] nums2={1,3,4};
        merge_list t=new merge_list();
        ListNode l1= ListNodeTool.buildList(nums1);
        ListNode l2= ListNodeTool.buildList(nums2);
        ListNodeTool.outputList(t.Merge_Original(l1,l2));
    }

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
