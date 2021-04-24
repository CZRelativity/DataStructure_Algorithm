package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.*;

public class zigzagLevelOrder103 {
    public static void main(String[] args) {
        zigzagLevelOrder103 t=new zigzagLevelOrder103();
        t.test();
    }

    private void test(){
        Integer[][] egA={{3,9,20,1,2,15,7,8,9,0},{},{1}};
        List<TreeNode> eg=new ArrayList<>();
        Arrays.stream(egA).forEach(e->eg.add(TreeNodeTool.buildOrderBT(e)));
        for(TreeNode root:eg){
            zigzagLevelOrder(root);
            res.forEach(System.out::println);
            System.out.println();
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        zigzag(s1,s2,2);
        return res;
    }

    private void zigzag(Stack<TreeNode> s,Stack<TreeNode> sNext,int level){
        if(s.isEmpty()){
            return;
        }
        List<Integer> list=new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode cur=s.pop();
            list.add(cur.val);
            if(level%2==0) {
                if (cur.left != null) {
                    sNext.push(cur.left);
                }
                if (cur.right != null) {
                    sNext.push(cur.right);
                }
            }else {
                if (cur.right != null) {
                    sNext.push(cur.right);
                }
                if (cur.left != null) {
                    sNext.push(cur.left);
                }
            }
        }
        res.add(list);
        zigzag(sNext,s,level+1);
    }
}
