package sword;

import tools.TreeNode;
import tools.TreeNodeTool;

public class MirrorTree27 {
    public static void main(String[] args){
        MirrorTree27 t=new MirrorTree27();
        Integer[] eg1=new Integer[]{4,2,7,1,3,6,9};
        TreeNode root= TreeNodeTool.buildOrderBT(eg1,0);
        TreeNodeTool.outBfBt(t.mirrorTree(root));
    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode mirrorRoot=new TreeNode(root.val);
        mirror(root,mirrorRoot);
        return mirrorRoot;
    }

    /* 树的递归，dp深搜，有点眉目了
    * 我们知道通过一个递归框架总可以遍历一个树的所有结点
    * 而且这个顺序其实是确定的，只要left的递归写在前面，
    * 总是先找到树最左下的结点，然后在返回栈的时候挨个栈查看有没有右节点
    * 从顺序上来讲是一个前序遍历，我们要做的是在需要的地方加入我们的操作 */
    public void mirror(TreeNode root,TreeNode mirrorRoot){
        if(root.left!=null){
            mirrorRoot.right=new TreeNode(root.left.val);
            mirror(root.left,mirrorRoot.right);
        }
        if(root.right!=null){
            mirrorRoot.left=new TreeNode(root.right.val);
            mirror(root.right,mirrorRoot.left);
        }
    }
}
