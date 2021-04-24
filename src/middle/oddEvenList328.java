package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class oddEvenList328 {
    public static void main(String[] args) {
        oddEvenList328 t = new oddEvenList328();
        t.test();
    }

    private void test() {
        int[][] eg = {{1, 2, 3, 4, 5, 6, 7, 8,}, {1, 2, 3, 4, 5,}, {2, 1, 3, 5, 6, 4, 7,}};
        for (int[] e : eg) {
            ListNode head = ListNodeTool.buildList(e);
            ListNodeTool.outputList(oddEvenList(head));
        }
    }

    //100%
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = new ListNode(-1);
        ListNode temp = evenHead;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null && even.next != null) {

            temp.next = even;
            temp = temp.next;

            //跳过一个偶结点
            odd.next = odd.next.next;
            /* 跳过后可直接移动到下个结点,
             * 以偶数结点结尾的时候比较麻烦，tempList要加这个偶结点，
             * temp指针要跳，但是odd和even指针都不能跳 */
            odd = odd.next;
            //被跳过的是他，对他的移动貌似没有影响
            even = even.next.next;
        }
        //如果以偶数结点结尾，判断最后一个奇数结点的next不为空可以避免空指针
        if (odd.next != null) {
            temp.next = even;
            temp = temp.next;
            odd.next = odd.next.next;
        }
        /* 需要打断此时temp指向的最后一个偶结点与下一个奇结点，
        否则到最后跟最后一个奇结点相接的时候会从最后一个奇结点成环，
        但也只用打断最后一个，在前面就打断的话会影响指针的移动*/

        temp.next = null;
        odd.next = evenHead.next;
        return head;
    }
}
