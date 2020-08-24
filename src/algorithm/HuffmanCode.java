package algorithm;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        HuffmanCode t = new HuffmanCode();
        System.out.println(Arrays.toString(t.example.getBytes()));
        System.out.println(Arrays.toString(str2bytes(t.code(t.example))));
    }

    String example = "i like like like java do you like a java";
    Map<Character, Node> nodeMap = new HashMap<>();
    Map<Byte, String> byteCodeMap = new HashMap<>();
    List<Node> nodeList = new ArrayList<>();
    Comparator<Node> nodeComparator = new Comparator<Node>() {
        @Override
        public int compare(Node node, Node t1) {
            return node.data - t1.data;
        }
    };

    public String code(String str) {

        /*将传入的str按字符出现次数作为权值生成Node，并按不同字符为key放入Hashmap*/
        char key;
        int value;
        for (int i = 0; i < str.length(); i++) {
            key = str.charAt(i);
            if (nodeMap.containsKey(key)) {
                value = nodeMap.remove(key).data;
                nodeMap.put(key, new Node(key, value + 1));
            } else {
                nodeMap.put(key, new Node(key, 1));
            }
        }

        /*因为map没有sort方法，所以借助set遍历map到list中，准备生成HuffmanTree*/
        Set<Character> keySet = nodeMap.keySet();
        for (char k : keySet) {
            nodeList.add(nodeMap.get(k));
        }

        /*正常生成HuffmanTree*/
        nodeList.sort(nodeComparator);
        while (nodeList.size() > 1) {
            Node n1 = nodeList.remove(0);
            Node n2 = nodeList.remove(0);
            nodeList.add(new Node(n1.data + n2.data, n1, n2));
            nodeList.sort(nodeComparator);
        }

        /*调用递归方法，按Huffman编码的原理生成各键值的编码并写入到新的byteCodeMap中，方便之后提取*/
        codeHuffmanTree(nodeList.get(0), "");

        /*重新回到我们之前的传入字符串，按照得到的byteCodeMap挨个把字符转成对应编码*/
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            strBuilder.append(byteCodeMap.get((byte) str.charAt(i)));
        }
        return strBuilder.toString();
    }

    public static byte[] str2bytes(String str){
        int byteLength,byteIndex=0;
        if(str.length()%8==0){
            byteLength=str.length()/8;
        }else{
            byteLength=str.length()/8+1;
        }
        byte[] bytesCode=new byte[byteLength];
        for(int i=0;i<str.length();i+=8) {
//            if(byteIndex==byteLength){
//                bytesCode=Arrays.copyOf(bytesCode,byteLength*2);//byte数组自动扩容
//            }
            if(i+8>str.length()){
                bytesCode[byteIndex++]=Byte.parseByte(str.substring(i),2);
                //之前测试过了，二进制字符串分段以后这样就可以转成想要的byte
            }else{
                bytesCode[byteIndex++]=(byte) Integer.parseInt(str.substring(i,i+8),2);
                // 终于是搞出来了，
                // 这个强制类型转换是肯定不会溢出的，也自动转无符号了，就是具体实现的原理还要再研究研究
            }
        }
        return bytesCode;
    }

    /*前序递归遍历树并将编码写入key对应的byte编码map中，这个map是更直观的结果，后面可以少很多读取的操作*/
    public void codeHuffmanTree(Node node, String code) {
        if (node.key != 0) {
            byteCodeMap.put((byte) node.key, code);
            //char转byte就是强制类型转换就可以了
        }
        if (node.left != null) {
            codeHuffmanTree(node.left, code + "0");
        }
        if (node.right != null) {
            codeHuffmanTree(node.right, code + "1");
        }
    }

//    public String decode(byte[] bytes) {
//
//    }

    class Node {
        int data;
        char key;
        Node left;
        Node right;

        public Node(char key, int data) {
            this.data = data;
            this.key = key;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
