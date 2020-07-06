package Easy_Test;

import Easy.merge_list;
import Tools.ListNode;
import Tools.ListNode_Tool;

public class test_merge_list {
    public static void main(String[] args) {
        int[] nums1={1,2,4};
        int[] nums2={1,3,4};
        merge_list t=new merge_list();
        ListNode l1= ListNode_Tool.Build_List(nums1);
        ListNode l2=ListNode_Tool.Build_List(nums2);
        ListNode_Tool.Output_List(t.Merge_Original(l1,l2));
    }
}
