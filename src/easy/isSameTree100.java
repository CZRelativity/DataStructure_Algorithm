package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class isSameTree100 {
    public static void main(String[] args){
        isSameTree100 t=new isSameTree100();
        TreeNode h1= TreeNodeTool.buildOrderBinaryTree(new int[]{1,2,3,4,5},0);
        TreeNode h2=TreeNodeTool.buildOrderBinaryTree(new int[]{1,2,3,4,6},0);
        TreeNode h3=TreeNodeTool.buildOrderBinaryTree(new int[]{1,2,1},0);
        TreeNode h4=TreeNodeTool.buildOrderBinaryTree(new int[]{1,1,2},0);
        boolean result= t.solveOriginal(h1,h2);
        System.out.println(result);
    }

    //时间100% !!!
    public boolean solveOriginal(TreeNode n1,TreeNode n2){
        if(n1==null&&n2==null){
            return true;
        }
        if(n1!=null&&n2!=null&&n1.val==n2.val){
            if(solveOriginal(n1.left,n2.left)){
                return solveOriginal(n1.right,n2.right);
            }
        }
        return false;
    }

}
