package Data_Structure;

import java.util.Stack;

//中缀表达式 Infix Expression
//后缀表达式 Suffix Expression
public class RPNCalculator {//逆波兰计算器
    Stack<Character> s1 = new Stack<>();
    Stack<Character> s2 = new Stack<>();
    Stack<Integer> sInt=new Stack<>();

    public static void main(String[] args) {
        RPNCalculator t=new RPNCalculator();
        System.out.println(t.calqRPN(t.getRPN("1+((2+3)*4)-5")));
    }

    public int calqRPN(String suffix){
        for (int index=0;index<suffix.length();index++){
            char temp=suffix.charAt(index);
            if (Character.isDigit(temp)){
                sInt.push((int)temp-'0');
            }else {
                int num1= sInt.pop();
                int num2= sInt.pop();
                switch (temp){
                    case '+':
                        sInt.push(num1+num2);
                        break;
                    case '-':
                        sInt.push(num2-num1);
                        break;
                    case '*':
                        sInt.push(num1*num2);
                        break;
                    case '/':
                        if (num1==0){
                            throw new RuntimeException("错误的表达式");
                        }
                        sInt.push(num2/num1);
                        break;
                }
            }
        }
        return sInt.pop();
    }

    public String getRPN(String infix) {
        char temp;
        for (int index = 0; index < infix.length(); index++) {
            temp = infix.charAt(index);
            if (Character.isDigit(temp)) {//遇到数，直接压入s2
                s2.push(temp);
            } else if (temp == '(' || temp == ')') {
                if (temp == '(') {
                    s1.push(temp);
                } else {
                    char popS1;
                    while (true) {
                        if (s1.empty()) {
                            throw new RuntimeException("错误的表达式！");
                        }
                        popS1 = s1.pop();
                        if (popS1 == '(') {//如果是),则一直从s1压入s2，直到找到最近的(，并一起丢弃
                            break;
                        }
                        s2.push(popS1);
                    }
                }
            } else {
                while (true) {
                    if(s1.empty()){
                        s1.push(temp);
                        break;
                    }//遇到运算符，则比较优先级
                    char charTop = s1.peek();
                    if ( charTop == '(') {
                        s1.push(temp);//如果栈顶为空或(，则直接入s1
                        break;
                    } else if (isHighLevel(temp) && !isHighLevel(charTop)) {
                        s1.push(temp);//若比s1栈顶优先级高，则入s1，实际上交换了顺序？这样以来s2里面优先级高的就到前面去了
                        break;
                    } else {//否则一直比较，
                        s2.push(s1.pop());
                    }
                }
            }
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        char[] out = new char[s2.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = s2.pop();
        }
        return new StringBuilder(String.valueOf(out)).reverse().toString();
    }


    public boolean isHighLevel(char operator) {
        if (operator == '*' || operator == '/') {
            return true;
        } else if (operator == '+' || operator == '-') {
            return false;
        } else throw new RuntimeException("错误的运算符！");
    }
}
