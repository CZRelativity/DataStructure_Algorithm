package middle;

import tools.ListNode;
import tools.ListNodeTool;

class addTwoNumbers2 {
    public static void main(String[] args) {
        addTwoNumbers2 t = new addTwoNumbers2();
        t.test();
    }

    private void test() {
        int[][] eg = {{2, 3, 4}, {5, 6, 4}, {9, 8, 7}};
        for (int i = 0; i < eg.length - 1; i++) {
            for (int j = i + 1; j < eg.length; j++) {
                ListNode l1 = ListNodeTool.buildList(eg[i]);
                ListNode l2 = ListNodeTool.buildList(eg[j]);
                ListNode lAdd = addTwoNumbersReference(l1, l2);
                ListNodeTool.outputList(lAdd);
            }
        }
    }

    //432+465=897（链表尾是最高位）
    public ListNode addTwoNumbersReference(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //对象就是指针
        ListNode end = head;  //开始创建一个0作为起点
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;   //获取进位
            sum = sum % 10; //当前位结果值
            end.next = new ListNode(sum); //存入指针对象
            end = end.next;   //移动到下个指针
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            end.next = new ListNode(1);
        }
        return head.next;
    }

    //时间99%
    public ListNode addTwoNumbersOriginal(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int curPosSum, carry = 0;
        ListNode curNode = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curPosSum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                curPosSum = l1.val;
                l1 = l1.next;
            } else {
                curPosSum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            curPosSum += carry;
            if (curPosSum >= 10) {
                curNode.next = new ListNode(curPosSum - 10);
                carry = 1;
            } else {
                curNode.next = new ListNode(curPosSum);
                carry = 0;
            }
            curNode = curNode.next;
        }
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        return head.next;
    }
}
