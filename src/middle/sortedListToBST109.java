package middle;

import tools.ListNode;
import tools.ListNodeTool;
import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;

public class sortedListToBST109 {
    public static void main(String[] args) {
        sortedListToBST109 t = new sortedListToBST109();
        t.test();
    }

    private void test() {
        int[][] eg = {{-10, -3, 0, 5, 9},};
        for (int[] e : eg) {
            ListNode head = ListNodeTool.buildList(e);
            TreeNode root = sortedListToBST(head);
            TreeNodeTool.outBfBt(root);
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> valList = new ArrayList<>();
        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }
        int[] valArr = valList.stream().mapToInt(Integer::intValue).toArray();
        return toBST(valArr, 0, valList.size() - 1);
    }

    private TreeNode toBST(int[] valArr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(valArr[mid]);
        root.left = toBST(valArr, left, mid - 1);
        root.right = toBST(valArr, mid + 1, right);
        return root;
    }
}
