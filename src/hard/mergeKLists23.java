package hard;

import tools.GeneralTool;
import tools.ListNode;
import tools.ListNodeTool;

import java.util.Arrays;
import java.util.PriorityQueue;

public class mergeKLists23 {
    public static void main(String[] args) {
        mergeKLists23 t = new mergeKLists23();
        t.test();
    }

    private void test() {
        String[] eg = {"[[1,4,5],[1,3,4],[2,6]]",};
        for (String e : eg) {
            int[][] arr2 = GeneralTool.getArr2(e);
            ListNode[] lists = new ListNode[arr2.length];
            for (int i = 0; i < arr2.length; i++) {
                lists[i] = ListNodeTool.buildList(arr2[i]);
            }
            ListNode merge = mergeKLists1(lists);
            ListNodeTool.outputList(merge);
        }
    }

    //遍历 7.4%
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tempHead = new ListNode(-1);
        ListNode temp = tempHead;
        while (true) {
            ListNode insert = null;
            int insertIndex = lists.length;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (insert == null || lists[i].val < insert.val) {
                        insert = lists[i];
                        insertIndex = i;
                    }
                }
            }
            if (insert == null) {
                break;
            } else {
                temp.next = insert;
                lists[insertIndex] = lists[insertIndex].next;
                temp = temp.next;
                temp.next = null;
            }
        }
        return tempHead.next;
    }

    //pq解法果然是完美的，所以到时候要自己写pq？
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode tempHead = new ListNode(-1);
        ListNode temp = tempHead;
        /* 最不容易错的就是用Integer.compare等方法或者自己写相应compare
        ，参数顺序就是顺排，参数倒序就是倒排 */
        PriorityQueue<ListNode> pq = new PriorityQueue<>(this::compareNode);
        //往pq加null会挂
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            /* 往pq里面添加null会挂，所以null直接不要了
            这里temp.next.next相当于pq.poll().next */
            if (temp.next.next != null) {
                pq.add(temp.next.next);
            }
            //果然无需打断
//            temp.next.next = null;
            temp = temp.next;
        }
        return tempHead.next;
    }

    //改每次排序链表数组，草，Comparator直接慢过遍历
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode tempHead = new ListNode(-1);
        ListNode temp = tempHead;
        int left = 0, right = lists.length - 1;
        while (true) {
//            Arrays.sort(lists, Comparator.
//                    nullsLast(Comparator.comparingInt(node -> node.val)));
            while (lists[right] == null) {
                right--;
                if (left >= right) {
                    break;
                }
            }
            quickSortOfRange(lists, left, right);
            if (lists[0] == null) {
                break;
            } else {
                temp.next = lists[0];
                lists[0] = lists[0].next;
                temp = temp.next;
                temp.next = null;
            }
        }
        return tempHead.next;
    }


    //手动排序，空的不仅要放到最后，而且下一次排序length要减少,好难嗷

    //希望通过返回null数来加快排序
    private void quickSortOfRange(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return;
        }
        int mark = right;
        for (int i = left; i < mark; ) {
            if (compareNode(lists[i], lists[mark]) > 0) {
                for (int j = i; j < mark; j++) {
                    ListNode temp = lists[j + 1];
                    lists[j + 1] = lists[j];
                    lists[j] = temp;
                }
                mark--;
            } else {
                i++;
            }
        }
        quickSortOfRange(lists, left, mark - 1);
        quickSortOfRange(lists, mark + 1, right);
    }

    //手写了归并，但是没有做到每次length减少，目前会超时
    private void mergeOfRange(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return;
        }
        int len = right - left + 1;
        mergeOfRange(lists, left, left + len / 2 - 1);
        mergeOfRange(lists, left + len / 2, right);
        if (len == 2) {
//            if (lists[left] == null || (lists[left] != null && lists[right] != null
//                    && lists[left].val > lists[right].val)) {
            if (compareNode(lists[left], lists[right]) > 0) {
                ListNode temp = lists[right];
                lists[right] = lists[left];
                lists[left] = temp;
            }
            return;
        }
        ListNode[] tempLists = new ListNode[len];
        int i1 = left, i2 = left + len / 2;
        for (int i = 0; i < len; i++) {
            if (i1 == left + len / 2) {
                tempLists[i] = lists[i2++];
            } else if (i2 == left + len) {
                tempLists[i] = lists[i1++];
            } else {
//                if (lists[i2] == null || (lists[i1] != null && lists[i2] != null
//                        && lists[i1].val < lists[i2].val)) {
                if (compareNode(lists[i1], lists[i2]) < 0) {
                    tempLists[i] = lists[i1++];
                } else {
                    tempLists[i] = lists[i2++];
                }
            }
        }
        System.arraycopy(tempLists, 0, lists, left, len);
    }

    private int compareNode(ListNode node1, ListNode node2) {
        int val1 = node1 == null ? Integer.MAX_VALUE : node1.val;
        int val2 = node2 == null ? Integer.MAX_VALUE : node2.val;
        if (val1 == val2) {
            return 0;
        } else {
            return val1 < val2 ? -1 : 1;
        }
    }

}
