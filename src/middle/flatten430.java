package middle;

import java.util.Stack;

public class flatten430 {
    public static void main(String[] args) {
        flatten430 t = new flatten430();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, null, 2, null, 3}, {1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12}};
        for (Integer[] e : eg) {
            Node head = build(e);
            head = flatten(head);
            outFlat(head);
        }
    }

    //100%
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> flatStack = new Stack<>();
        Node temp = head;
        while (temp.next != null || temp.child != null) {
            if (temp.child != null) {
                if (temp.next != null) {
                    flatStack.add(temp.next);
                }
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            temp = temp.next;
        }
        while (!flatStack.isEmpty()) {
            Node insert = flatStack.pop();
            insert.prev = temp;
            temp.next = insert;
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        return head;
    }

    private Node build(Integer[] base) {
        Node head = new Node(base[0]);
        Node levelHead = head;
        Node temp = head;
        int i = 1;
        while (i < base.length) {
            if (base[i] == null) {
                temp = levelHead;
                while (base[i + 1] == null) {
                    i++;
                    temp = temp.next;
                }
                i++;
                temp.child = new Node(base[i++]);
                temp = temp.child;
                levelHead = temp;
            } else {
                temp.next = new Node(base[i++]);
                temp.next.prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    private void outFlat(Node head) {
        System.out.print(head.val);
        Node temp = head.next;
        Node pre = temp;
        while (temp != null) {
            System.out.print("->" + temp.val);
            pre = temp;
            temp = temp.next;
        }
        System.out.println();
        System.out.print(pre.val);
        pre = pre.prev;
        while (pre != null) {
            System.out.print("->" + pre.val);
            pre = pre.prev;
        }
        System.out.println();
    }

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }
}
