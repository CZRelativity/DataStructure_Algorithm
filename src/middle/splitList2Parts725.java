package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.ArrayList;
import java.util.List;

public class splitList2Parts725 {
    public static void main(String[] args) {
        splitList2Parts725 t = new splitList2Parts725();
        t.test();
    }

    private void test() {
        int[][] eg = {{}, {1, 2, 3, 4}, {1, 2, 3}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        int[] egK = {5, 5, 5, 3};
        for (int i = 0; i < eg.length; i++) {
            ListNode root = ListNodeTool.buildList(eg[i]);
            ListNode[] res = splitListToParts(root, egK[i]);
            for (ListNode l : res) {
                ListNodeTool.outputList(l);
            }
        }
    }

    //100%
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int remainder = len % k;
        int part = len / k;
        List<ListNode> ret = new ArrayList<>();
        temp = root;
        while (ret.size() < k) {
            ret.add(temp);
            int count = part;
            if (remainder > 0) {
                count++;
                remainder--;
            }
            if (temp != null) {
                for (; count > 1; count--) {
                    temp = temp.next;
                }
                ListNode pre = temp;
                temp = temp.next;
                pre.next = null;
            }
        }
        return ret.toArray(new ListNode[0]);
    }
}
