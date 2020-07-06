package Data_Structure;

import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroListNode l1 = new HeroListNode(1, "宋江", "及时雨");
        //非静态内部类需要new OrderListNode.new HeroListNode，不能脱离外部类实体被创建
        HeroListNode l2 = new HeroListNode(2, "卢俊义", "玉麒麟");
        HeroListNode l3 = new HeroListNode(3, "吴用", "智多星");
        HeroListNode l4 = new HeroListNode(4, "林冲", "豹子头");
        singleLinkedList.update(l1);
        singleLinkedList.update(l2);
        singleLinkedList.update(l3);
        singleLinkedList.update(l4);
//        singleLinkedList.output();

//        singleLinkedList.update(new HeroListNode(2,"小卢","小玉"));
//        singleLinkedList.output();

//        singleLinkedList.delete(3);
//        singleLinkedList.output();
//        System.out.println(singleLinkedList.validNode());
//        HeroListNode node=singleLinkedList.getNode(3);
//        System.out.println(node.no+" "+node.name+" "+node.nickname);

        singleLinkedList.reverseHeroListNode();
        singleLinkedList.output();

//        singleLinkedList.reverseOutput();
    }

    HeroListNode head = new HeroListNode(0, "", "");
    //这个外部类好像就是为了头结点存在的- -，哦还有测试函数

    void update(HeroListNode listNode) {
        HeroListNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = listNode;
                break;
            }
            if (listNode.no == temp.next.no) {//如果存在这个节点，即替换
                listNode.next = temp.next.next;//同样是在前一个节点的位置，发现下一个节点是重复的，然后
                //把新点接上下下个点，再把上个点接上新点
                temp.next = listNode;
                break;
            } else if (listNode.no < temp.next.no) {//要顺序插入一个节点，
                // 我们的temp必须是要插入的前一个点，才能通过next插入
                listNode.next = temp.next;//把插入点的next接上下一点
                temp.next = listNode;//把前一点的next接上我们的插入点
                break;
            }
            temp = temp.next;
        }
    }

    void delete(int no) {
        HeroListNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;//上一个点接上下下个点，实现跳过下个点（delete）
                break;
            }
            temp = temp.next;
        }
    }

    void output() {
        HeroListNode temp = head;
        temp = temp.next;
        while (temp != null) {
            System.out.println(temp.no + " " + temp.name + " " + temp.nickname);
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseOutput(){
        HeroListNode temp=head.next;
        Stack<HeroListNode> stack=new Stack<>();
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        while (!stack.empty()){
//            System.out.println(stack.pop());
            HeroListNode t=stack.pop();
            System.out.println(t.no+" "+t.name+" "+t.nickname);
        }
    }

    int validNode(){
        int count=0;
        HeroListNode temp=head;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    HeroListNode getNode(int k){
        HeroListNode temp=head;
        while (k>0){
            if(temp==null){
                throw new RuntimeException("节点不存在！");
            }
            temp=temp.next;
            k--;
        }
        return temp;
    }

    void reverseHeroListNode(){
//        HeroListNode temp=head;
//        temp=temp.next;
        head.next= reverseUtil_Recursion(head.next);
//        reverseUtil_Iterate(head);
    }

    HeroListNode reverseUtil_Recursion(HeroListNode head){
        if (head.next==null){
            return head;//这个递归的条件总会找到最后一个非空节点返回
        }
        HeroListNode node=reverseUtil_Recursion(head.next);//4返回了，此时3是头，
        // 然后之后两句把4指向3，3指向空，其他同理
        head.next.next=head;//下一个节点指向前一个
        head.next=null;//前一个指空，否则两个节点就互相指，循环了
        //确实对象名其实是指针，用任何一个copy的指针去修改对象的属性，所有copy指针找到的那个对象都改了
        return node;//就返回最后一个节点（反转后的头节点）
//        node倒其实一直没有变，每次返回的都是指4的指针，每个栈里面不同的就是局部变量head
    }

    void reverseUtil_Iterate(HeroListNode head){
        if (head==null||head.next==null){
            return;
        }
        HeroListNode cur=head.next;
        HeroListNode next=null;
        HeroListNode reverse_head=new HeroListNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverse_head.next;//这个其实应该更好理解，每次推一个cur进这个reverse
            //reverse用来储存之前进来的，然后后进来的直接指向reverse的头
            reverse_head.next=cur;//比如前一条用来把3指向2，这一条用来把3存进reverse链表，
            // 下次从3开始了
            cur=next;
        }
        head.next=reverse_head.next;
    }

    static class HeroListNode {//一个静态内部类
        int no;
        String name;
        String nickname;
        HeroListNode next;

        public HeroListNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }
    }
}
