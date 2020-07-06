package Tools;

public class ListNode_Tool {
    public static void Output_List(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode Build_List(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode end = head;
        if (nums.length == 1) return head;
        else {
            int i = 1;
            while (i < nums.length) {
                end.next = new ListNode(nums[i]);
                end = end.next;
                i++;
            }
        }
        return head;
    }

}
