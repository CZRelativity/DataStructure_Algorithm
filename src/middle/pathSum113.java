package middle;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.ArrayList;
import java.util.List;

public class pathSum113 {
    public static void main(String[] args) {
        pathSum113 t=new pathSum113();
        t.test();
    }

    private void test(){
        Integer[] eg1=new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
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
        TreeNode root= TreeNodeTool.buildOrderBt(eg1);
        pathSum(root,eg1s);
        for(List<Integer> list:res){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        search(root,new ArrayList<>(),0,sum);
        return res;
    }

    private void search(TreeNode root,List<Integer> path,int curSum,int sum){
        if(root==null){
            return;
        }
        curSum+=root.val;
        path.add(root.val);
        if(curSum==sum&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
        }
        //传拷贝√ 传引用× 传引用导致自始至终只有一个path List，得到的路径是一个部分的前序遍历
        search(root.left,new ArrayList<>(path),curSum,sum);
        /* 如果是引用的话，在去到11的右结点之前，就已经在前一句中往List添加了左结点7，这里会继续往添加以后的List添加,
        关键就是这两句传入的不能是同一个List地址 */
        search(root.right,new ArrayList<>(path),curSum,sum);
    }
}
