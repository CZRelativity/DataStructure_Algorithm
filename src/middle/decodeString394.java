package middle;

import java.util.Stack;

public class decodeString394 {
    public static void main(String[] args) {
        decodeString394 t = new decodeString394();
        t.test();
    }

    private void test() {
        String[] eg = {"3[a2[c]]", "3[a]2[bc]", "2[abc]3[cd]ef", "abc3[cd]xyz"};
        for (String e : eg) {
            System.out.println(decodeString(e));
        }
    }

    //87%
    public String decodeString(String s) {
        //正括号反括号常用栈
        Stack<Integer> leftBracketStack = new Stack<>();
        String replace, bReplaced;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                leftBracketStack.push(i);
            } else if (c == ']') {
                int pLeftBracket = leftBracketStack.pop();
                int pNum = pLeftBracket - 1;
                while (pNum - 1 >= 0 && s.charAt(pNum - 1) >= '0' && s.charAt(pNum - 1) <= '9') {
                    pNum--;
                }
                int repeat = Integer.parseInt(s.substring(pNum, pLeftBracket));
                replace = s.substring(pLeftBracket + 1, i).repeat(repeat);
                bReplaced = s.substring(pNum, i + 1);
                s = s.replace(bReplaced, replace);
                //细节，替换以后要把长度变化带来的索引变化抹平，才能继续进行扫描
                i -= bReplaced.length() - replace.length();
            }
        }
        return s;
    }
}
