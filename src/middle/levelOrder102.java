package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder102 {
    public static void main(String[] args){
        levelOrder102 t=new levelOrder102();
        Integer[] eg1=new Integer[]{3,9,20,null,null,15,7};
        TreeNode eg= TreeNodeTool.buildOrderBt(eg1,0);
        t.levelOrder(eg);
        for(List<Integer> level:t.res){
            for(int i:level){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    //参数化类的原始使用：指没有使用泛型
    List<List<Integer>> res=new ArrayList<>();
    Queue<TreeNode> queue1=new LinkedList<>();
    Queue<TreeNode> queue2=new LinkedList<>();

    //双队列，时间92%，内存99%
    public List<List<Integer>> levelOrder(TreeNode root) {
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
