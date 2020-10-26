package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.ArrayList;
import java.util.List;

public class swapPairs24 {

    public static void main(String[] args) {
        swapPairs24 t=new swapPairs24();
        int[] eg1=new int[]{1,2,3,4};
        int[] eg2=new int[]{};
        int[] eg3=new int[]{1};
        int[] eg4=new int[]{1,2,3,4,5};
        ListNode head= ListNodeTool.buildList(eg4);
        ListNode res=t.swapPairsRecursion(head);
        ListNodeTool.outputList(res);
    }

    //两次线性迭代，这次又冲100%了
//    public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode temp=head;
//        List<ListNode> list=new ArrayList<>();
//        ListNode next;
//        while (temp!=null&&temp.next!=null){
//            next=temp.next.next;
//            temp.next.next=temp;
//            list.add(temp.next);
//            temp.next=null;
//            temp=next;
//        }
//        if(temp!=null){
//            list.add(temp);
//        }
//        for(int i=0;i<list.size()-1;i++){
//            list.get(i).next.next=list.get(i+1);
//        }
//        return list.get(0);
//    }

    public ListNode swapPairsRecursion(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        //递归，一句顶一个list
        head.next=swapPairsRecursion(next.next);
        next.next=head;
        return next;
    }
}
