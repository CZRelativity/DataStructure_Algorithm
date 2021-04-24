package easy;

import tools.TreeNode;
import tools.TreeNodeTool;

public class isSameTree100 {
    public static void main(String[] args){
        isSameTree100 t=new isSameTree100();
        t.test();
    }

    private void test(){
        Integer[][] eg1={{1,2,3,4,5},{1,2,1},{1,2,3}};
        Integer[][] eg2={{1,2,3,4,6},{1,1,2},{1,2,3}};
        for(int i=0;i<eg1.length;i++){
            TreeNode n1=TreeNodeTool.buildOrderBT(eg1[i]);
            TreeNode n2=TreeNodeTool.buildOrderBT(eg2[i]);
            System.out.println(isSameTree(n1,n2));
        }
    }

    //时间100% !!!
    public boolean isSameTree(TreeNode p, TreeNode q){

        if(p==null&&q==null){
            return true;
        }
        return p!=null&&q!=null&&p.val==q.val&&
                isSameTree(p.left,q.left)&&
                isSameTree(p.right,q.right);
    }

}
