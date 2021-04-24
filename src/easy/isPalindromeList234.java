package easy;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.Stack;

public class isPalindromeList234 {
    public static void main(String[] args) {
        isPalindromeList234 t = new isPalindromeList234();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2}, {1, 2, 2, 1}, {}, {1}};
        for (int[] e : eg) {
            ListNode head = ListNodeTool.buildList(e);
            System.out.println(isPalindromeO1(head));
        }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != nodeStack.pop().val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    /* 时间99.9%，思路，快慢指针找中间结点，反转后半链表，再从头和从中间指针依次比较 */
    private boolean isPalindromeO1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseListIteration(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到最后一个非null的结点返回
        ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private ListNode reverseListIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
