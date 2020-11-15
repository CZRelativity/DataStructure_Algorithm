package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class deleteDuplicates82 {
    public static void main(String[] args) {
        deleteDuplicates82 t = new deleteDuplicates82();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 3, 4, 4, 5}, {1, 1, 1, 2, 3}, {1, 1, 1, 1,}, {1, 1, 2, 2}};
        for (int[] e : eg) {
            ListNode head = ListNodeTool.buildList(e);
            ListNode res = deleteDuplicates(head);
            ListNodeTool.outputList(res);
        }
    }

    //时间 89%
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //111222这种情况
        while (head.next != null && head.next.val == head.val) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            if (head.next == null) {
                return null;
            } else {
                head = head.next;
            }
        }
        //中间重复的情况:1233445
        ListNode cur = head.next, pre = head;
        //pre一直是cur的前一个，不可能空指针
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == pre.next.val) {
                    cur = cur.next;
                }
                /* 这个时候不能动pre,但必须要动cur,动了pre已经指向下一个或者没动cur还指向被删除的结点，
                都无法完全删除连续重复 */
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
