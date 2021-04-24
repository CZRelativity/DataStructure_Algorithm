package middle;

import java.util.Stack;

public class calculate227 {
    public static void main(String[] args) {
        calculate227 t = new calculate227();
        t.test();
    }

    private void test() {
        String[] eg = {"14/3*2", "12-3*4", "42", "7*2*2-5+1-5+3-4", "3+2*6-2", "3+2*2", " 3/2 ", " 3+5 / 2 "};
        for (String e : eg) {
            System.out.println(calculate(e));
        }
    }

    Stack<Character> charStack;

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        charStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            //处理多位数
            if (Character.isDigit(c)) {
                int parse = i + 1;
                //parse总是停在数字的后一位，可以直接用substring
                while (parse < chars.length && Character.isDigit(chars[parse])) {
                    parse++;
                }
                numStack.push(Integer.parseInt(s.substring(i, parse)));
                i = parse - 1;
                //处理运算符
            } else {
                //新的运算符与栈顶同级，或者比栈顶运算符的优先级低，那么不能插入，需要把栈顶弹出先运算了，持续比较栈顶直到可以插入（甚至栈空）
                while (!charStack.isEmpty() && !(isHigherLevel(c))) {
                    numStack.push(cal(numStack.pop(), numStack.pop(), charStack.pop()));
                }
                charStack.push(c);
            }
        }
        while (!charStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), charStack.pop()));
        }
        return numStack.peek();
    }

    private int cal(int n1, int n2, char c) {
        int ret;
        switch (c) {
            case '+':
                ret = n1 + n2;
                break;
            case '-':
                ret = n2 - n1;
                break;
            case '*':
                ret = n1 * n2;
                break;
            case '/':
                ret = n2 / n1;
                break;
            default:
                ret = -1;
        }
        return ret;
    }

    //因为只有higherLevel的运算符是可以直接插入的
    private boolean isHigherLevel(char c) {
        if (charStack.isEmpty()) {
            return true;
        }
        if (c == '*' || c == '/') {
            return charStack.peek() == '+' || charStack.peek() == '-';
        }
        return false;
    }
}
