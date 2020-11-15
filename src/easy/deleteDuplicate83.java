package easy;

import tools.ListNode;
import tools.ListNodeTool;

public class deleteDuplicate83 {
    public static void main(String[] args) {
        deleteDuplicate83 t=new deleteDuplicate83();
        t.test();
    }

    private void test(){
        int[][] eg={{1,1,2},{1,1,2,3,3},{1,1,1,},{1,1,2,2}};
        for(int[] e:eg){
            ListNode head= ListNodeTool.buildList(e);
            ListNode res=deleteDuplicates(head);
            ListNodeTool.outputList(res);
        }
    }

    //时间第一次 70% 第二次100% 叒
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //因为可能长达几个重复，所以多用一个pre指针方便
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            if (cur.val == pre.val) {
                while (cur!=null&&cur.val == pre.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
