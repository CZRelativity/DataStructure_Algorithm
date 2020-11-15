package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.Arrays;

public class minDepth111 {
    public static void main(String[] args) {
        minDepth111 t = new minDepth111();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{3, 9, 20, null, null, 15, 7},
                {2, null, 3, null, 4, null, 5, null, 6},
                {}};
        for (Integer[] e : eg) {
            TreeNode root = TreeNodeTool.deserialize(Arrays.asList(e).toString().replaceAll(" ",""));
            System.out.println(minDepth2(root));
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    int minDepth;

    public int minDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        minDepth = Integer.MAX_VALUE;
        search(root,1);
        return minDepth;
    }

    private void search(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth < minDepth) {
                minDepth = depth;
            }
            return;
        }
        if (node.left != null) {
            search(node.left, depth + 1);
        }
        if (node.right != null) {
            search(node.right, depth + 1);
        }
    }
}
