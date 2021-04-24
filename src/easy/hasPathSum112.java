package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class hasPathSum112 {
    public static void main(String[] args) {
        hasPathSum112 t=new hasPathSum112();
        Integer[] eg1=new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        Integer[] eg2=new Integer[]{1,2};
        Integer[] eg3=new Integer[]{};
        Integer[] eg4=new Integer[]{1};
        //还要考虑负数。。。
        Integer[] eg5=new Integer[]{-2,null,-3};
        Integer[] eg6=new Integer[]{1,-2,-3,1,3,-2,null,-1};
        int eg1s=22;
        int eg2s=1;
        int eg5s=-5;
        int eg6s=-1;
        TreeNode root= TreeNodeTool.buildOrderBT(eg4);
        boolean res=t.hasPathSum(root,eg2s);
        System.out.println(res);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return search(root,0,sum);
    }

    //要求终点必须是叶子节点，也就是没有左右子结点
    private boolean search(TreeNode root,int curSum,int sum){
        if(root==null){
            return false;
        }
        curSum+=root.val;
        if(curSum==sum&&root.left==null&&root.right==null){
            return true;
        }
        /*
        小于则继续搜索，多用 或 与 节省if（删去了条件：因为符号的存在，比sum大了也可以加负数得到sum）
        因为或的关系，一个true就是整个true
        */
        return search(root.left,curSum,sum)||search(root.right,curSum,sum);
    }
}
