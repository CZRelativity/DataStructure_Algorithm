package tools;

public class ListNodeTool {

    public static void outputList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode buildList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode end=head;
        for(int i=1;i<nums.length;i++){
            end.next=new ListNode(nums[i]);
            end=end.next;
        }
        return head;
    }

    public static ListNode buildList(int[] nums,int cycConnectPos){
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode end=head;
        for(int i=1;i<nums.length;i++){
            end.next=new ListNode(nums[i]);
            end=end.next;
        }
        if(cycConnectPos>=0){
            ListNode temp=head;
            while(cycConnectPos>0){
                temp=head.next;
                cycConnectPos--;
            }
            end.next=temp;
        }
        return head;
    }

}
