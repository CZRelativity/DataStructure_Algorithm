package Data_Structure;

public class BinaryTree {

    public static void main(String[] args){
        BinaryTree t=new BinaryTree();
        SimpleNode root=t.buildArrBinaryTree(new int[]{1,2,3,4,5,6,7},0);
        t.preOrderList(root);
        System.out.println();
        t.inOrderList(root);
        System.out.println();
        t.postOrderList(root);
        System.out.println();
//        t.postOrderDelete(root,3);
    }

    //前序中序后序遍历
    void preOrderList(SimpleNode node){
        System.out.print(node.id+" ");
        if(node.left!=null){
            preOrderList(node.left);
        }
        if(node.right!=null){
            preOrderList(node.right);
        }
    }

    void inOrderList(SimpleNode node){
        if(node.left!=null){
            inOrderList(node.left);
        }
        System.out.print(node.id+" ");
        if(node.right!=null){
            inOrderList(node.right);
        }
    }

    void postOrderList(SimpleNode node){
        if(node.left!=null){
            postOrderList(node.left);
        }
        if(node.right!=null){
            postOrderList(node.right);
        }
        System.out.print(node.id+" ");
    }
    //前序中序后序查找
    
    SimpleNode inOrderSearch(SimpleNode node,int find){
        if(node.left!=null){
            inOrderSearch(node.left,find);
        }
        if(node.id==find){
            return node;
        }
        if(node.right!=null){
            inOrderSearch(node.right,find);
        }
        return null;
    }

    //改、删
    //如果只有一个子结点， 就用子结点代替；如果有两个子结点，就用左子结点代替
    void postOrderDelete(SimpleNode node,int id){
        if(node.left.id==id){
            if(node.left.left==null&&node.left.right!=null){
                node.left=node.left.right;
            }else {
                node.left=node.left.left;
            } return;
        }else if (node.right.id==id) {
            if(node.right.left==null&&node.right.right!=null){
                node.right=node.right.right;
            }else{
                node.right=node.right.left;
            }
            return;
        }
        if(node.left!=null){
            postOrderDelete(node.left,id);
        }
        if(node.right!=null){
            postOrderDelete(node.right,id);
        }
    }

//    void inOrderThread(SimpleNode pre,SimpleNode current){
//        if(current==null){
//            return;
//        }
//        inOrderThread(current,current.left);//问题，限制了pre只能是父节点，实际上不是的
//        if(current.left==null){
//            current.left=pre;
//            current.isLeftToPre=true;
//        }
//        if(pre!=null&&pre.right==null){
//            pre.right=current;
//            pre.isRightToNext=true;
//        }
//        inOrderThread(current,current.right);
//    }

    //这是用顺序存储二叉树的公式来前序递归创建的，否则就需要在数组设空节点，或者是需要两个顺序的遍历数组才能唯一确定一个树
    SimpleNode buildArrBinaryTree(int[] arr,int index){
        if(index>=arr.length){
            return null;
        }
        SimpleNode root=new SimpleNode(arr[index]);
        if(2*index+1<arr.length)
        {
            root.left=buildArrBinaryTree(arr,2*index+1);
        }
        if(2*index+2<arr.length)
        {
            root.right=buildArrBinaryTree(arr,2*index+2);
        }
        return root;
    }

    class SimpleNode{
        int id;
        SimpleNode left;
        SimpleNode right;
//        boolean isLeftToPre;
//        boolean isRightToNext;

        public SimpleNode(int id){
            this.id=id;
//            this.isLeftToPre=false;
//            this.isRightToNext=false;
        }
    }
}
