package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;

public class pathSum113 {
    public static void main(String[] args) {
        pathSum113 t = new pathSum113();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, {1, 2},
                {}, {1}, {-2, null, -3}, {1, -2, -3, 1, 3, -2, null, -1}};
        int[] egS = {22, 1, 1, 1, -5, -1};
        for (int i = 0; i < eg.length; i++) {
            TreeNode root = TreeNodeTool.buildOrderBT(eg[i]);
            List<List<Integer>> lists = pathSum(root, egS[i]);
            lists.forEach(System.out::println);

            System.out.println();
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        search(root, new ArrayList<>(), 0, sum);
        return res;
    }

    private void search(TreeNode root, List<Integer> path, int curSum, int sum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        path.add(root.val);
        if (curSum == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        //传拷贝√ 传引用× 传引用导致自始至终只有一个path List，得到的路径是一个部分的前序遍历
        search(root.left, new ArrayList<>(path), curSum, sum);
        /* 如果是引用的话，在去到11的右结点之前，就已经在前一句中往List添加了左结点7，这里会继续往添加以后的List添加,
        关键就是这两句传入的不能是同一个List地址 */
        search(root.right, new ArrayList<>(path), curSum, sum);
    }
}
