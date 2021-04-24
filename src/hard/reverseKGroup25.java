package hard;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.List;

public class reverseKGroup25 {
    public static void main(String[] args) {
        reverseKGroup25 t = new reverseKGroup25();
        t.test();
    }

    private void test() {
        int[][] head = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int[] k = {1, 2, 3};
        for (int i = 0; i < head.length; i++) {
            ListNode h = reverseKGroup(ListNodeTool.buildList(head[i]), k[i]);
            ListNodeTool.outputList(h);
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode temp = tempHead;
        ListNode pre = tempHead, next;
        while (temp.next != null) {
            temp = temp.next;
            count++;
            if (count == k) {
                //暂存
                next = temp.next;
                //打断
                temp.next = null;
                //翻转
                ListNode[] nodes = reverse1(head);
                //头尾重接
                pre.next = nodes[0];
                nodes[1].next = next;
                //准备下次
                pre = nodes[1];
                head = pre.next;
                temp = pre;
                count = 0;
            }
        }
        return tempHead.next;
    }

    private ListNode[] reverse1(ListNode head) {
        ListNode tempHead = new ListNode(-1);
        ListNode tempNext;
        ListNode end = head;
        //头插法
        while (head != null) {
            tempNext = tempHead.next;
            //插到头
            tempHead.next = head;
            /* 这两句的顺序，我们需要head.next，
            而在把head给tempHead.next了以后我们已经不再需要head,
            所以这个指针可以马上用来存储head.next */
            head = head.next;
            /* 这里仍可以通过tempHead.next来获取到之前的head，而如果交换两句的顺序
             * 会丢失原来的head.next */
            tempHead.next.next = tempNext;
        }
        return new ListNode[]{tempHead.next, end};
    }

    private ListNode reverse2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = reverse2(head.next);
        /* 全程跟返回的node都没有关系！node只是为了保存头结点
        就是一个从尾结点开始不断反指再打断的过程 */
        head.next.next = head;
        head.next = null;
        return node;
    }
}
