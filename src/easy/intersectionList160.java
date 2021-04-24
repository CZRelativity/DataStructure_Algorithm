package easy;

import tools.ListNode;
import tools.ListNodeTool;

public class intersectionList160 {
    public static void main(String[] args) {
        intersectionList160 t = new intersectionList160();
        int[] a1 = new int[]{4,};
        int[] b1 = new int[]{5, 0,};
        int[] c1 = new int[]{1, 8, 4, 5,};
        int[] a2 = new int[]{2, 6, 4};
        int[] b2 = new int[]{1, 5};
        int[] a3 = new int[]{1, 3,};
        ListNode headA = ListNodeTool.buildList(a3);
        ListNode headB = ListNodeTool.buildList(b1);
        ListNode headC = ListNodeTool.buildList(c1);
        ListNodeTool.getEndNode(headA).next = headC;
        ListNodeTool.getEndNode(headB).next = headC;
        ListNode res = t.getIntersectionNode(headA, null);
        System.out.println(res == null ? "null" : res.val);
    }

    /*c表示公共部分，若相交a+c+b+c=b+c+a+c，两指针会在相交结点处相遇
     * 若不相交，a+b=b+a，两指针相遇处必为null,同样可以得到pA=pB=null*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        //表面.equals跟等于是一样的，但是.equals会报空指针0.0，==完全不会
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
