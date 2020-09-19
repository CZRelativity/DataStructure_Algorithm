package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class AddLinked {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {5, 6, 4};
        int[] nums3 = {9, 8, 7};
        ListNode l1 = ListNodeTool.buildList(nums1);
        ListNode l2 = ListNodeTool.buildList(nums2);
        ListNode l3 = ListNodeTool.buildList(nums3);
        AddLinked op = new AddLinked();
        ListNode head = op.addTwoNumbersOriginal(l1, l2);
        ListNodeTool.outputList(head);
        System.out.println("\n");
        head = op.addTwoNumbersOriginal(l1, l3);
        ListNodeTool.outputList(head);
        System.out.println("\n");
        head = op.addTwoNumbersOriginal(l2, l3);
        ListNodeTool.outputList(head);
    }

    public ListNode addTwoNumbersOriginal(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //对象就是指针
        ListNode end = head;  //开始创建一个0作为起点
        int carry = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;   //获取进位
            sum = sum % 10; //当前位结果值
            end.next = new ListNode(sum); //存入指针对象
            end = end.next;   //移动到下个指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            end.next = new ListNode(1);
        }
        return head.next;
    }
}
