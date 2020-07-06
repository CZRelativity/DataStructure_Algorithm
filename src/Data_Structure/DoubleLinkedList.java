package Data_Structure;

public class DoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList t=new DoubleLinkedList();

        t.update(new HeroNode2(2, "卢俊义", "玉麒麟"));
        t.update(new HeroNode2(1, "宋江", "及时雨"));
        t.update(new HeroNode2(4, "林冲", "豹子头"));
        t.update(new HeroNode2(3, "吴用", "智多星"));
        t.output();

        t.update(new HeroNode2(2,"小卢","小玉"));
        t.delete(3);
        t.output();
        t.reverseOutput();
    }

    HeroNode2 head = new HeroNode2(0, "", "");
    HeroNode2 end = new HeroNode2(99, "", "");

    public DoubleLinkedList(){
        head.next=end;
        end.pre=head;
    }

    void output() {
        if (head.next == end) {
            System.out.println("空表！");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != end) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseOutput(){//双向链表逆序打印简直不要太爽
        if (end.pre==head){
            System.out.println("空表！");
            return;
        }
        HeroNode2 temp=end.pre;
        while (temp!=head){
            System.out.println(temp);
            temp=temp.pre;
        }
        System.out.println();
    }

    void update(HeroNode2 node) {//自己写的双向链表双向查找顺序插入和修改！
        HeroNode2 fTemp = head;
        HeroNode2 bTemp = end;
        while (true) {//双向链表太香了再也不用判断空了
            if (fTemp.next.no > node.no) {//正序插入
                node.next = fTemp.next;
                node.pre = fTemp;
                fTemp.next.pre = node;
                fTemp.next = node;
                break;
            } else if (fTemp.next.no == node.no) {//正序替换
                node.next = fTemp.next.next;
                node.pre = fTemp;
                fTemp.next.next.pre=node;
                fTemp.next=node;
                break;
            }else if (bTemp.pre.no<node.no){//逆序插入
                node.next=bTemp;
                node.pre=bTemp.pre;
                bTemp.pre.next=node;
                bTemp.pre=node;
                break;
            }else if (bTemp.pre.no==node.no){//逆序替换
                node.next=bTemp;
                node.pre=bTemp.pre.pre;
                bTemp.pre.pre.next=node;
                bTemp.pre=node;
                break;
            }
            fTemp = fTemp.next;
            bTemp = bTemp.pre;
        }

    }

    void delete(int no) {
        HeroNode2 fTemp = head;
        HeroNode2 bTemp = end;
        while (true) {
            if (fTemp.no>=bTemp.no) {
                if (fTemp.no == no) {
                    fTemp.pre.next = fTemp.next;
                    fTemp.next.pre = fTemp.pre;
                } else {
                    System.out.println("节点不存在！");
                    break;
                }
            }
            if (fTemp.no == no) {
                fTemp.pre.next = fTemp.next;
                fTemp.next.pre = fTemp.pre;
                break;
            } else if (bTemp.no == no) {
                bTemp.pre.next = bTemp.next;
                bTemp.next.pre = bTemp.pre;
                break;
            }
            fTemp = fTemp.next;
            bTemp = bTemp.pre;
        }
    }

    static class HeroNode2 {

        public HeroNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        int no;
        String name, nickname;
        HeroNode2 next;
        HeroNode2 pre;

        @Override
        public String toString() {
            return "HeroNode2{" + no + "," + name + "," + nickname + "}";
        }
    }
}
