package middle;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList138 {
    public static void main(String[] args) {

    }

    private void test() {

    }

    //100%，random_index是迷惑人的！
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //最牛逼的映射就是地址到地址的映射
        Map<Node, Node> old2NewMap = new HashMap<>();
        Node copyHead = new Node(0);
        Node copyPointer = copyHead;
        Node originPointer = head;
        while (originPointer != null) {
            Node copy = new Node(originPointer.val);
            copyPointer.next = copy;
            copyPointer = copyPointer.next;
            old2NewMap.put(originPointer, copy);
            originPointer = originPointer.next;
        }
        originPointer = head;
        copyPointer = copyHead.next;
        while (originPointer != null) {
            /* 不用把random关系解析成指向index，根本不需要index的概念，
            你需要的是旧结点的random指向哪个旧结点，
            直接映射成新结点的random指向的新结点 */
            copyPointer.random = old2NewMap.get(originPointer.random);
            originPointer = originPointer.next;
            copyPointer = copyPointer.next;
        }
        return copyHead.next;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
