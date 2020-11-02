package middle;

import tools.ListNode;
import tools.ListNodeTool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class sortList148 {
    public static void main(String[] args) {
        sortList148 t = new sortList148();
        ListNode eg1 = ListNodeTool.buildList(new int[]{4, 2, 1, 3});
        ListNode eg2 = ListNodeTool.buildList(new int[]{-1, 5, 3, 4, 0});
        ListNode head= t.solve(eg2);
        ListNodeTool.outputList(head);
    }

    Comparator<ListNode> listNodeComparator =
            Comparator.comparingInt(listNode -> listNode.val);

    public ListNode solve(ListNode head) {
        if(head==null){
            return null;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        listNodeList.sort(listNodeComparator);
        ListNode last = listNodeList.get(0);
        int i = 1;
        for (; i < listNodeList.size(); i++) {
            last.next = listNodeList.get(i);
            last = last.next;
        }
        last.next = null;
        return listNodeList.get(0);
    }
}
