package dataStructure;

public class Josephu {

    public static void main(String[] args) {
        Josephu t=new Josephu();
//        KidNode key=t.buildList(5,1);
//        t.outList(key,2);
        KidNode key=t.buildList(7,2);
        t.outList(key,3);
    }

    KidNode head= new KidNode(0);

    public KidNode buildList(int n,int k){
        KidNode temp=head;
        KidNode key=head;
        for (int i=1;i<=n;i++) {
            temp.next = new KidNode(i);
            temp = temp.next;
            if (i==k){
                key=temp;
            }
        }
        temp.next=head.next;
        return key;
    }

    public void outList(KidNode key,int m){
        KidNode temp=key;
        int i=1;
        while(true){
            if (i==(m-1)){
                if (temp.next==temp){
                    System.out.println(temp);
                    return;
                }
                System.out.println(temp.next);
                temp.next=temp.next.next;
                temp=temp.next;
                i=1;
                continue;
            }
            i++;
            temp=temp.next;
        }
    }

    class KidNode{
        int no;
        public KidNode next;

        public KidNode(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "KidNode:{ "+no+" }";
        }
    }
}