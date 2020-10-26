package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

public class isValidBST98 {
    public static void main(String[] args) {
        isValidBST98 t = new isValidBST98();
        Integer[] eg1Arr=new Integer[]{5,1,4,null,null,3,6};
        Integer[] eg2Arr=new Integer[]{10,5,15,null,null,6,20};
        Integer[] eg3Arr=new Integer[]{1,1};
        Integer[] eg4Arr=new Integer[]{-2147483648};
        TreeNode eg= TreeNodeTool.buildOrderBt(eg4Arr,0);
        boolean res= t.isValid(eg);
        System.out.println(res);
    }

    //以最最小值作为递归的起始值
    private long preVal=Long.MIN_VALUE;
    //中序递归一定是从最左最小开始按顺序修改preVal的，将preVal定义成对象属性不用传值

    /**不是左右结点满足就可以了，要左右子树都满足
     * 一定要留意BST的性质：中序遍历时应该是一个有序数组！
     * @param root 根结点
     * @return 是否有效的二叉搜索树
     */
    public boolean isValid(TreeNode root){
        //在递归一开始设置退出条件null，这样在主程序开头不用判断，在后面左右结点时也不用判断
        if(root==null) {
            return true;
        }
        //返回boolean的递归一定要写在if条件里
        if(!isValid(root.left)){
            return false;
        }

        if(preVal<root.val){
            preVal=root.val;
        }else{
            return false;
        }
        //中序
        return isValid(root.right);
    }
}
