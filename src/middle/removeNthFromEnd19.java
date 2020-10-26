package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class removeNthFromEnd19 {
    public static void main(String[] args) {
        removeNthFromEnd19 t=new removeNthFromEnd19();
        int[] eg1=new int[]{1,2,3,4,5};
        int[] eg2=new int[]{1,};
        ListNode res= t.removeNthFromEnd(ListNodeTool.buildList(eg1),5);
        ListNodeTool.outputList(res);
    }

    //双100分
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;
        //假设n都是有效的，意思不可能比链表结点数还多
        while (n>0){
            fast=fast.next;
            n--;
        }
        //意思就是n等于结点数
        if(fast==null){
            //草，这个意思，删除头结点，意思直接返回下个结点作为头结点
            return head.next;
        }
        //做了前面的判断，fast肯定不等于null了
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        /*n不可能是0，链表也不可能是空，所以fast至少比slow领先1，
        * slow不可能是空*/
        slow.next=slow.next.next;
        return head;
    }
}
