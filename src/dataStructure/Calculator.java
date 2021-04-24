package dataStructure;

import java.util.Arrays;

public class Calculator {

    static String operators = "+-*/";
    stack<Integer> numStack = new stack<>();
    stack<Character> charStack = new stack<>();

    public static void main(String[] args) {

        Calculator t = new Calculator();
        //int[]会自动放0，而obj[]会自动放null(即使泛型Integer)
        //这种情况下面向对象可真香
        t.SimuCalculator("72+89*12-90/2");
        t.SimuCalculator("3+2*6*2-2");
    }

    public void SimuCalculator(String exp) {
        if (!numStack.isEmpty() || !charStack.isEmpty()) {
            throw new RuntimeException("计算器未初始化!");
        }
        int index = 0;
        int mark = 0;
        int len = 0;
        while (index != exp.length()) {
            char charTemp = exp.charAt(index);
            if (charTemp >= '0' && charTemp <= '9') {
                if (index != exp.length() - 1 && exp.charAt(index + 1) >= '0' && exp.charAt(index + 1) <= '9') {
                    mark = index;
                    len++;
                } else {
                    if (len != 0) {
                        numStack.push(Integer.parseInt(exp.substring(mark, index + 1)));
                        len = 0;
                        //这里endIndex的意思是取这之前的
                    } else {
                        numStack.push(charTemp - '0');//*超级厉害的char转int方法，适用于单独数字
                    }
                }
            } else {
                if (operators.contains(String.valueOf(charTemp))) {
                    if (!charStack.isEmpty()) {
                        char charTop = charStack.getTop();
                        if ((charTop != '+' && charTop != '-') || (charTemp != '*' && charTemp != '/')) {
                            Calculate();
                        }
                    }
                    charStack.push(charTemp);
                }
            }
            index++;
        }
//        同级符号都是要算了才入的，这也解决了连续高阶的问题
//        最后符号栈里面要么：1、一直插同级的话符号栈里只会有一个同级符号
//        2、插低级高级然后一直高级的话最后符号栈会有一个低级一个高级
//        3、低级高级再低级最后符号栈会有两个低级，因为再插低级的时候把之前的高级替换了
//        同级和低级对于符号栈的逻辑是替换
        while (numStack.top != 0) {
            Calculate();
        }
        System.out.println("Result : " + numStack.pop());
    }

    void Calculate() {
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        switch (charStack.pop()) {
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num2 - num1);
                break;
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                numStack.push(num2 / num1);
                break;
            default:
                break;
        }
    }

    static class stack<T> {
        int top;
        T[] arr;

        public stack() {
            top = -1;
            arr = (T[]) new Object[10];//这种初始化泛型数组的方法会warning，有无更好的？
        }

//        public T[] arrayWithTypeToken(Class<T> type, int size) {
//            return (T[]) Array.newInstance(type, size);
//        }//这报一样的警告啊，我还是用最简单的那种吧...

        void show() {
            System.out.println(Arrays.toString(arr));
        }

        T pop() {
            if (isEmpty()) {
                throw new RuntimeException("空栈！");
            } else {
                T obj = arr[top];
                arr[top] = null;
                top--;
                return obj;
            }
        }

        T getTop() {
            if (isEmpty()) {
                return null;
            } else {
                return arr[top];
            }
        }

        void push(T obj) {
            if (isFull()) {
                throw new RuntimeException("满栈！");
            } else {
                top++;
                arr[top] = obj;
            }
        }

        void clear() {
            while (!isEmpty()) {
                pop();
            }
        }

        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == 9;
        }
    }
}
