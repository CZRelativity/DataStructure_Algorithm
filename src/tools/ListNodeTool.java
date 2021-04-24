package tools;

import java.util.List;

public class ListNodeTool {

    public static void outputList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static ListNode buildList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode end = head;
        for (int i = 1; i < nums.length; i++) {
            end.next = new ListNode(nums[i]);
            end = end.next;
        }
        return head;
    }

    public static ListNode getEndNode(ListNode head) {
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        return end;
    }

    public static ListNode buildCycleList(int[] nums, int cycConnectPos) {
        ListNode head = buildList(nums);
        ListNode end = head;
        while (end != null && end.next != null) {
            end = end.next;
        }
        if (cycConnectPos >= 0) {
            ListNode temp = head;
            while (cycConnectPos > 0) {
                temp = head.next;
                cycConnectPos--;
            }
            end.next = temp;
        }
        return head;
    }

}
