package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.Stack;

public class reverseBetween92 {
    public static void main(String[] args) {
        reverseBetween92 t=new reverseBetween92();
        t.test();
    }

    private void test(){
        int[][] eg={{1,2,3,4,5},{1,2,3,},{1}};
        int[][] egMN={{2,4},{3,3},{1,1}};
        for(int i=0;i<eg.length;i++){
            ListNodeTool.outputList(reverseBetween(ListNodeTool.buildList(eg[i]),egMN[i][0],egMN[i][1]));
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead=new ListNode(-1);
        tempHead.next=head;
        ListNode pre=tempHead;
        while(m>1){
            pre=pre.next;
            m--;
            n--;
        }
        Stack<ListNode> nodeStack=new Stack<>();
        ListNode connect=pre.next;
        while(n>0){
            nodeStack.push(connect);
            connect=connect.next;
            n--;
        }
        ListNode reverseHead=nodeStack.pop();
        ListNode reverse=reverseHead;
        while(!nodeStack.isEmpty()){
            reverse.next=nodeStack.pop();
            reverse=reverse.next;
        }
        pre.next=reverseHead;
        reverse.next=connect;
        return tempHead.next;
    }
}
