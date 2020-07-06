package Middle_Test;

import Tools.ListNode;
import Tools.ListNode_Tool;
import Middle.add_linked;

public class test_add_linked {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {5, 6, 4};
        int[] nums3 = {9, 8, 7};
        ListNode l1 = ListNode_Tool.Build_List(nums1);
        ListNode l2 = ListNode_Tool.Build_List(nums2);
        ListNode l3 = ListNode_Tool.Build_List(nums3);
        add_linked op = new add_linked();
        ListNode head = op.addTwoNumbers_Original(l1, l2);
        ListNode_Tool.Output_List(head);
        System.out.println("\n");
        head = op.addTwoNumbers_Original(l1, l3);
        ListNode_Tool.Output_List(head);
        System.out.println("\n");
        head = op.addTwoNumbers_Original(l2, l3);
        ListNode_Tool.Output_List(head);
    }
}