package middle;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class differentBST95 {
    public static void main(String[] args){
        differentBST95 t=new differentBST95();
        t.generate(1,4);
    }

//    List<TreeNode> treeNodeList;
//    List<Integer> arrangeList;
//    boolean[] used;
//
//    public differentBST95(){
//        treeNodeList=new ArrayList<>();
//    }
//
//    public void solveOriginal(int n){
//        used=new boolean[n];
//        arrangeList=new ArrayList<>(n);
//        generate(arrangeList,n,n);
//    }
//
//    public void generate(List<Integer> arrangeList,int size,int n){
//        if(n==0) {
//            treeNodeList.add(generateBSTFromArrList(arrangeList));
//        }else {
//            for (int i=0;i<size;i++){
//                if(!used[i]) {
//                    arrangeList.add(i+1);
//                    used[i] = true;
//                    generate(arrangeList, size, n - 1);
//                    arrangeList.remove(arrangeList.size() - 1);
//                    used[i] = false;
//                }
//            }
//        }
//    }
//
//    public TreeNode generateBSTFromArrList(List<Integer> arr){
//        System.out.println(arr.toString());
//        TreeNode root=new TreeNode(arr.get(0));
//        int curNum;
//        for (int i=1;i<arr.size();i++){
//            curNum= arr.get(i);
//            TreeNode temp=root;
//            while(true){
//                if(curNum>temp.val){
//                    if(temp.right==null){
//                        temp.right=new TreeNode(curNum);
//                        break;
//                    }else {
//                        temp=temp.right;
//                    }
//                }else {
//                    if (temp.left==null){
//                        temp.left=new TreeNode(curNum);
//                        break;
//                    }else {
//                        temp=temp.left;
//                    }
//                }
//            }
//        }
//        return root;
//    }

    //单纯的求排列没有考虑到二叉搜索树的性质，会出现难以避免的重复，如213和231排列不同，但对于BST来说是等价的
    public List<TreeNode> solveLR(int n){
        if(n<1){
            return new ArrayList<>();
        }
        return generate(1,n);
    }

    //时间99.7%，动态规划会更快？
    public List<TreeNode> generate(int start,int end){
        List<TreeNode> treeList=new ArrayList<>();
        //不添加null的话下面不会进增强for，尴尬，虽然不推荐这么做，但添加null仅改变了size，在这种场景下还是有用的
        if(start>end){
            treeList.add(null);
        }
        else if(start==end){
            treeList.add(new TreeNode(start));
        }else{
            //依次作为根结点
            for (int i=start;i<=end;i++){
                //用index范围把左右分开递归，再把递归结果直接双for进行组合
                List<TreeNode> leftTreeList=generate(start,i-1);
                List<TreeNode> rightTreeList=generate(i+1,end);
                for (TreeNode leftTree:leftTreeList){
                    for (TreeNode rightTree:rightTreeList){
                        TreeNode root=new TreeNode(i);
                        root.left=leftTree;
                        root.right=rightTree;
                        treeList.add(root);
                    }
                }
            }
        }
        return treeList;
    }
}
