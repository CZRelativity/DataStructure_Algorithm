package data_structure;

public class BinarySortTree extends algorithm.Sort {

    public static void main(String[] args) {
        BinarySortTree t = new BinarySortTree();

        t.testRandom(8000);
        System.out.println();

        //测试查找删除二叉排序树结点的三种情况
        t.sort(new int[]{7,3,10,12,5,1,9,2});
        t.searchDelete(t.root,null,false,2);
        t.inOrderList(t.root);
        System.out.println();

        t.add(new SimpleNode(2));
        t.searchDelete(t.root,null,false,1);
        t.inOrderList(t.root);
        System.out.println();
        t.searchDelete(t.root,null,false,10);
        t.inOrderList(t.root);
    }

    private SimpleNode root;

    private int index;

    /*厉害就在于中序输出就是个有序数组，这真是个排序*/
    @Override
    public int[] sort(int[] arr) {
        root=null;
        for(int i:arr){
            add(new SimpleNode(i));
        }
        if(root!=null){
            index=0;
            inOrderListSort(root,arr);
        }
        return arr;
    }


    public void inOrderListSort(SimpleNode node,int[] arr){
        if(node.left!=null){
            inOrderListSort(node.left,arr);
        }
        arr[index]=node.no;
        index++;
        if(node.right!=null){
            inOrderListSort(node.right,arr);
        }
    }

    public void inOrderList(SimpleNode node){
        if(node.left!=null){
            inOrderList(node.left);
        }
        System.out.print(node.no+" ");
        if(node.right!=null){
            inOrderList(node.right);
        }
    }


    /**二叉排序树的任何一个非叶子结点，左结点的值都比当前结点小，右结点的值都比当前结点大，
     * 相同的值可以放在左结点也可以放在右结点
     * @param node 新增的结点
     */
    public void add(SimpleNode node) {
        if (root == null) {
            root = node;
            return;
        }
        SimpleNode temp = root;
        while (true) {
            /*循环的思路是比较以后判断放的左右，如果要放的方向结点存在就
            * 移动结点，再比较判断，不存在就放置结点然后退出循环，由二叉排序树的特点*/

            if (node.no < temp.no) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = node;
                    break;
                }
            } else{
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = node;
                    break;
                }
                /*不加下面的话有一样的结点会出不了循环，这边简单节点就直接不管了，如果有值的话是修改里面的值*/
            }
        }
    }

    /*递归的话每次移动都要判断根结点吧感觉不舒服*/


    public void searchDelete(SimpleNode node,SimpleNode parent,boolean isLeftNode,int targetNo){

        if(node.left!=null){
            searchDelete(node.left,node,true,targetNo);
        }

        if(node.no>targetNo){
            return;
        }
        if(node.no==targetNo){

            if(node.left==null&&node.right==null){
                /*最简单的情况，目标没有子结点*/
                if(isLeftNode){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
                return;


            }else if(node.left==null){
                /*目标仅有右子结点*/
                if(isLeftNode){
                    parent.left=node.right;
                }else{
                    parent.right=node.right;
                }
                return;

            }else if(node.right==null){
                /*目标仅有左子结点*/
                if(isLeftNode){
                    parent.left=node.left;
                }else{
                    parent.right=node.left;
                }

                return;

            }else{
                /*目标有左右两子结点*
                *可选查找右子树最小值替换或者查找左子树最大值替换，这边选前*/
                SimpleNode tempNode=node.right;
                SimpleNode tempParent=null;
                int tempNo;

                //不能直接把某个结点=null吗？不能,只能使指针不指向他
                while(tempNode.left!=null){
                    tempParent=tempNode;
                    tempNode=tempNode.left;
                }

                tempNo=tempNode.no;
                //先记录下值然后把结点置空,这边要考虑没有进入之前while循环的情况，避免空指针异常
                if(tempParent==null){
                    node.right=null;
                }else{
                    tempParent.left=null;
                }

                //目标结点值换成记录的值
                node.no=tempNo;

                return;
            }
        }

        if(node.right!=null){
            searchDelete(node.right,node,false,targetNo);
        }
    }

    static class SimpleNode {
        int no;
        SimpleNode left;
        SimpleNode right;

        public SimpleNode(int no) {
            this.no = no;
        }
    }
}
