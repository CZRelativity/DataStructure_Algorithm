package tools;

import java.util.*;

public class TreeNodeTool {

    //公式法，递归，但是不适用于有null的情况,因为一个null其实是会打乱下一层的公式计算的
    public static TreeNode buildOrderBt(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.left = buildOrderBt(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            root.right = buildOrderBt(arr, 2 * index + 2);
        }
        return root;
    }

    /* 使用反序列化来处理的时候传入的String里包含空格会打乱Integer.parseInt()方法，
     * 而如果用例如Arrays.asList(int[]).toString()方法会在每个逗号后自动加一个空格
     * 不过可以额外使用String.replaceAll(" ","")来处理 */
    public static TreeNode deserialize(String data) {
        if(data.length()==2){
            return null;
        }
        List<Integer> builder = new ArrayList<>();
        int left = 1, right = 1;
        while (right < data.length()) {
            char curC = data.charAt(right);
            if (curC == ',' || curC == ']') {
                if (Character.isDigit(data.charAt(left))||data.charAt(left)=='-') {
                    builder.add(Integer.parseInt(data.substring(left, right)));
                } else {
                    builder.add(null);
                }
                left = right + 1;
            }
            right++;
        }
        return buildOrderBt(builder.toArray(new Integer[0]));
    }

    public static TreeNode buildOrderBt(Integer[] builder) {
        if (builder.length == 0) {
            return null;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode root = new TreeNode(builder[0]);
        q1.add(root);
        buildLevel(q1, q2, builder, 1, builder.length);
        return root;
    }

    private static void buildLevel(Queue<TreeNode> q, Queue<TreeNode> qNext, Integer[] arr, int i, int l) {
        if (i >= l) {
            return;
        }

        while (!q.isEmpty()) {
            TreeNode curNode = q.remove();
            if (i < l && arr[i] != null) {
                curNode.left = new TreeNode(arr[i]);
                qNext.add(curNode.left);
            }
            if (i + 1 < l && arr[i + 1] != null) {
                curNode.right = new TreeNode(arr[i + 1]);
                qNext.add(curNode.right);
            }
            i += 2;
        }

        buildLevel(qNext, q, arr, i, l);
    }

    public static void outBfBt(TreeNode root) {
        System.out.println(serialize(root));
    }

    public static String serialize(TreeNode root) {
        List<Integer> serialize = new ArrayList<>();
        if (root == null) {
            return serialize.toString();
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);

        //迭代写法
//        while (!queue1.isEmpty()||!queue2.isEmpty()){
//            if(queue1.isEmpty()){
//                outLevel(queue2, queue1);
//            }else {
//                outLevel(queue1, queue2);
//            }
//        }

        //递归写法
        serializeLevel(queue1, queue2, serialize);
        //移除最后多余的null
        while (serialize.get(serialize.size() - 1) == null) {
            serialize.remove(serialize.size() - 1);
        }
        return serialize.toString().replaceAll(" ", "");
    }

    private static void serializeLevel(Queue<TreeNode> queue, Queue<TreeNode> nextQueue, List<Integer> serialize) {
        //利用集合可以add(null)，会占位置改变size
        if (queue.isEmpty()) {
            return;
        }
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            serialize.add(curNode == null ? null : curNode.val);
            //只要左右结点有一个不是null就应该继续添加的，但是又有1,2,3,null,null,4,5这种情况
            if (curNode != null) {
                nextQueue.add(curNode.left);
                nextQueue.add(curNode.right);
            }
        }
        serializeLevel(nextQueue, queue, serialize);
    }

}
