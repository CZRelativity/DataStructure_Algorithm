package middle;

import tools.ListNode;
import tools.ListNodeTool;

public class detectCycle142 {
    public static void main(String[] args) {
        detectCycle142 t=new detectCycle142();
        t.test();
    }

    private void test(){
        int[][] eg={{3,2,0,-4},{1,2},{1},{}};
        int[] egP={1,0,-1,0};
        for(int i=0;i<eg.length;i++){
            ListNode head= ListNodeTool.buildCycleList(eg[i],egP[i]);
            ListNode pos=detectCycle(head);
            System.out.println(pos==null?null:pos.val);
        }
    }

    /* 第一次相遇 Sf=Ss+nCyc & Sf=2Ss(2倍速度),则Ss=nCyc
    * 第二次相遇 Ss=Sf(相同速度) & a=a+nCyc (表示相遇) & Sf=Ss+nCyc(之前的Ss) */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow.equals(fast)){
                fast=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
