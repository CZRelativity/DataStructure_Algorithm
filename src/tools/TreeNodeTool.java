package tools;

import dataStructure.BinaryTree;

public class TreeNodeTool {

    public static TreeNode  buildOrderBinaryTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBinaryTree(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBinaryTree(arr, 2 * index + 2);
        }
        return root;
    }

}
