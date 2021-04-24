package middle;

import tools.GeneralTool;
import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView199 {
    public static void main(String[] args) {
        rightSideView199 t = new rightSideView199();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, 2, 3, null, 5, null, 4}};
        for (Integer[] e : eg) {
            System.out.println(bfs(TreeNodeTool.buildOrderBT(e)));
        }
    }

    List<Integer> ret;

    public List<Integer> rightSideView(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root, 0);
        return ret;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        //因为每层只会加一个！？
        if (depth == ret.size()) {
            ret.add(root.val);
        }
        //优先向右，就这么简单？！
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    //单队列bfs
    public List<Integer> bfs(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.remove();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (i == levelSize - 1) {
                    ret.add(cur.val);
                }
            }
        }
        return ret;
    }
}
