package dataStructure;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args){
        HuffmanTree t=new HuffmanTree();
        t.preOrderList(t.build(new int[]{13,7,8,3,29,6,1}));
    }

    List<Node> list = new ArrayList<>();

    Comparator<Node> comparator= (n1, n2) -> n1.data-n2.data;

    //lambda写法
    //Comparator<Node> comparator=Comparator.comparingInt(n -> n.data);

    public void preOrderList(Node node){
        System.out.print(node.data+" ");
        if(node.left!=null){
            preOrderList(node.left);
        }
        if(node.right!=null){
            preOrderList(node.right);
        }
    }

    public Node build(int[] arr){
        for(int i:arr){
            list.add(new Node(i));
        }
        Collections.sort(list);//想要对一个对象集合做排序，固定的规则可以实现Comparable接口，然后用Collection.sort()传入对象集合，
        // 灵活的规则可以写Comparator，直接用对象集合.sort()传入Comparator对象
        int size=list.size();
        Node n1,n2;
        while(size>1){
            n1=list.remove(0);
            n2=list.remove(0);//remove会返回被移除的元素,取前两个就是连着取第一个就行了，因为remove了以后会自动调整index
            list.add(new Node(n1.data+ n2.data,n1,n2));
            list.sort(comparator);//这里用comparator写了
            size=list.size();
        }
        return list.get(0);
    }

    class Node implements Comparable<Node>{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }

        public Node(int data, Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }

        @Override
        public int compareTo(Node node) {//这个有点绕，再梳理一下：
            //this是第一个元素，node是用来比较的第二个元素，返回负值的话，表示this比node小，排序时放在前面
            //与本来的第一个第二个同序，所以是顺序
            //想要把小的放在后面即倒序，就要这时返回正值
            return this.data-node.data;//这个表达式是this小的时候返回负值,相反的话就是倒序
        }
    }
}
