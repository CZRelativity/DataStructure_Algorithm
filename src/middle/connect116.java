package middle;

import java.util.LinkedList;
import java.util.Queue;

public class connect116 {
    public static void main(String[] args) {

    }

    private void test(){

    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> q1=new LinkedList<>();
        Queue<Node> q2=new LinkedList<>();
        q1.add(root);
        bfConnect(q1,q2);
        return root;
    }

    private void bfConnect(Queue<Node> q, Queue<Node> qNext){
        if(q.isEmpty()){
            return;
        }
        while (!q.isEmpty()){
            Node cur=q.remove();
            if(!q.isEmpty()){
                cur.next=q.peek();
            }
            if(cur.left!=null){
                qNext.add(cur.left);
            }
            if(cur.right!=null){
                qNext.add(cur.right);
            }
        }
        bfConnect(qNext,q);
    }

    private class Node{

        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val){
            this.val=val;
        }
    }
}
