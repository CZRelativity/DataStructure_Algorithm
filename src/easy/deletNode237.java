package easy;

import tools.ListNode;
import tools.ListNodeTool;

public class deletNode237 {
    public static void main(String[] args) {
        deletNode237 t = new deletNode237();
        t.test();
    }

    private void test() {
        int[][] eg = {{4, 5, 1, 9}};
        for (int[] e : eg) {
            head = ListNodeTool.buildList(e);
            deleteNode(head);
            ListNodeTool.outputList(head);
        }
    }

    ListNode head;

    /* 如何让自己消失，但又不死（保留地址，但不保留值），将自己完全变成另一个人，再杀了那个人（复制后结点的值，再删除后结点） */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
