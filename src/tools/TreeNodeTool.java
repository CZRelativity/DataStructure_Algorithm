package tools;

import java.util.*;

public class TreeNodeTool {

    public static TreeNode getNodeByVal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = getNodeByVal(root.left, val);
        return ret == null ? getNodeByVal(root.right, val) : ret;
    }

    //公式法，递归，但是不适用于有null的情况,因为一个null其实是会打乱下一层的公式计算的
    public static TreeNode buildOrderBT(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBT(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBT(arr, 2 * index + 2);
        }
        return root;
    }

    /* 使用反序列化来处理的时候传入的String里包含空格会打乱Integer.parseInt()方法，
     * 而如果用例如Arrays.asList(int[]).toString()方法会在每个逗号后自动加一个空格
     * 不过可以额外使用String.replaceAll(" ","")来处理 */
    public static TreeNode deserialize(String data) {
        data = data.replaceAll(" ", "");
        if (data.length() == 2) {
            return null;
        }
        List<Integer> builder = new ArrayList<>();
        int left = 1, right = 1;
        while (right < data.length()) {
            char curC = data.charAt(right);
            if (curC == ',' || curC == ']') {
                if (Character.isDigit(data.charAt(left)) || data.charAt(left) == '-') {
                    builder.add(Integer.parseInt(data.substring(left, right)));
                } else {
                    builder.add(null);
                }
                left = right + 1;
            }
            right++;
        }
        return buildOrderBT(builder.toArray(new Integer[0]));
    }

    public static TreeNode buildOrderBT(Integer[] builder) {
        if (builder.length == 0) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(builder[0]);
        q.add(root);
        int i = 1, len = builder.length;
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (i < len && builder[i] != null) {
                cur.left = new TreeNode(builder[i]);
                q.add(cur.left);
            }
            if (i + 1 < len && builder[i + 1] != null) {
                cur.right = new TreeNode(builder[i + 1]);
                q.add(cur.right);
            }
            i += 2;
        }
        return root;
    }

    public static void outBfBt(TreeNode root) {
        System.out.println(serialize(root));
    }

    public static String serialize(TreeNode root) {
        Deque<Integer> serialize = new LinkedList<>();
        if (root == null) {
            return serialize.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //单队列迭代写法
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            serialize.add(cur == null ? null : cur.val);
            //有1,2,3,null,null,4,5这种情况，所以不能判断左右结点非空
            if (cur != null) {
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        //移除最后多余的null
        while (serialize.getLast() == null) {
            serialize.removeLast();
        }
        return serialize.toString().replaceAll(" ", "");
    }

}
