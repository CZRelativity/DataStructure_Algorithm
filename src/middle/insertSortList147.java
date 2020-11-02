package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class insertSortList147 {
    public static void main(String[] args) {
        insertSortList147 t=new insertSortList147();
        t.test();
    }

    private void test(){
        ListNode eg1= ListNodeTool.buildList(new int[]{4,2,1,3});
        ListNode eg2=ListNodeTool.buildList(new int[]{-1,5,3,4,0});
        ListNodeTool.outputList(insertionSortList(eg1));
        ListNodeTool.outputList(insertionSortList(eg2));
    }

    //没有要求不能借空间的话，还是借空间好写
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode sort = new ListNode(Integer.MIN_VALUE);
        sort.next=new ListNode(head.val);
        while (head.next != null) {
            head=head.next;
            ListNode temp=sort;
            while(true){
                if(temp.next==null){
                    temp.next=new ListNode(head.val);
                    break;
                }else {
                    if(temp.next.val>head.val){
                        ListNode insert=new ListNode(head.val);
                        insert.next=temp.next;
                        temp.next=insert;
                        break;
                    }
                }
                temp=temp.next;
            }
        }
        return sort.next;
    }
}
