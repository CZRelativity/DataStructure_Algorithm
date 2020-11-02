package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class rotateRight61 {
    public static void main(String[] args){
        rotateRight61 t=new rotateRight61();
        t.test();
    }

    private void test(){

        ListNode eg1= ListNodeTool.buildList(new int[]{1,2,3,4,5});
        eg1=rotateRight(eg1,2);
        ListNodeTool.outputList(eg1);

        ListNode eg2=ListNodeTool.buildList(new int[]{0,1,2});
        eg2=rotateRight(eg2,4);
        ListNodeTool.outputList(eg2);

        ListNode eg3=ListNodeTool.buildList(new int[]{1,2});
        eg3=rotateRight(eg3,1);
        ListNodeTool.outputList(eg3);

        ListNode eg4=ListNodeTool.buildList(new int[]{1,2});
        eg4=rotateRight(eg4,3);
        ListNodeTool.outputList(eg4);

    }

    public ListNode rotateRight(ListNode head, int k) {
//        if(head==null){
//            return head;
//        }
//        ListNode left=head,right=head;
//        boolean cycle=false;
//        /* 循环进行的两个条件/终止循环必须满足的两个条件：
//        * 链表已经成环，而且左右指针之间的距离达到k */
//        while (!cycle||k>-1){
//            if(k<0){
//                left=left.next;
//            }
//            if(right.next==null){
//                right.next=head;
//                cycle=true;
//            }
//            right=right.next;
//            k--;
//        }
//        head=left.next;
//        left.next=null;
//        return head;

        //我的思路太复杂了，其实在不破坏O(n)的情况下多次循环简化问题是好的
        if(head==null){
            return null;
        }
        ListNode count=head;
        int l=1;
        while(count.next!=null){
            count=count.next;
            l++;
        }
        //在l范围内，新的头是倒数第几个结点，2%5=2 4%3=1;
        k=k%l;
        //以环形链表来看，0的话相当于原头
        if(k==0){
            return head;
        }
        ListNode newHead=head,newEnd=head;
        //据此找到新的头
        for(int i=0;i<l-k;i++){
            newHead=newHead.next;
        }
        //把新的头之前打断，于是新的尾就是新头的前一个结点哦
        for(int j=0;j<l-k-1;j++){
            newEnd=newEnd.next;
        }
        //最后才连成环
        count.next=head;
        //打断
        newEnd.next=null;
        return newHead;
    }
}
