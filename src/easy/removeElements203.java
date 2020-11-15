package easy;

import tools.ListNode;
import tools.ListNodeTool;

public class removeElements203 {
    public static void main(String[] args){
        removeElements203 t=new removeElements203();
        t.test();
    }

    private void test(){
        int[][] eg={{1,2,6,3,4,5,6},{1},{1,2,2,1}};
        int[] egV={6,1,2};
        for(int i=0;i<eg.length;i++){
            ListNode head= ListNodeTool.buildList(eg[i]);
            ListNode res=removeElements(head,egV[i]);
            ListNodeTool.outputList(res);
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }

        /* 需要删除头结点的情况
        * 其实可以设一个假头 */
//        while (head.val==val){
//            head=head.next;
//            if(head==null){
//                return null;
//            }
//        }

        //需要动头结点的情况尽量考虑假头
        ListNode tempHead=new ListNode(0);
        tempHead.next=head;
        ListNode temp=tempHead;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
                /* 一样的问题，如果此次循环做了删除操作就不要再跳
                转，不然就没办法应对需要连续删除的情况，也因为在
                 删除以后还在前结点所以不会有删除以后当前结点直接变成null的情况*/
            }else {
                temp = temp.next;
            }
        }
        return tempHead.next;
    }
}
