package middle;

import tools.ListNode;
import tools.TreeNode;

import java.util.*;

public class levelOrderBottom107 {
    public static void main(String[] args) {

    }

    //参数化类的原始使用：指没有使用泛型
    List<List<Integer>> res=new ArrayList<>();
    Queue<TreeNode> queue1=new LinkedList<>();
    Queue<TreeNode> queue2=new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return res;
        }

        queue1.add(root);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            List<Integer> levelRes=new ArrayList<>();
            if(queue1.isEmpty()){
                parseLevel(levelRes, queue2, queue1);
            }else {
                parseLevel(levelRes, queue1, queue2);
            }
            res.add(levelRes);
        }
        //Collections类 永远滴神
        Collections.reverse(res);

        return res;
    }

    private void parseLevel(List<Integer> levelRes,Queue<TreeNode> queue, Queue<TreeNode> nextQueue) {

        while(!queue.isEmpty()){
            TreeNode curNode= queue.remove();
            levelRes.add(curNode.val);
            if(curNode.left!=null){
                nextQueue.add(curNode.left);
            }
            if(curNode.right!=null){
                nextQueue.add(curNode.right);
            }
        }
    }
}
