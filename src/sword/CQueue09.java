package sword;

import java.util.Stack;

public class CQueue09 {

    public static void main(String[] args) {

    }

    //双栈互相倒腾法- -，12%
    class CQueue {

        Stack<Integer> lastTopStack;
        Stack<Integer> firstTopStack;

        public CQueue() {
            lastTopStack = new Stack<>();
            firstTopStack = new Stack<>();
        }

        public void appendTail(int value) {
            while (!firstTopStack.isEmpty()) {
                lastTopStack.push(firstTopStack.pop());
            }
            lastTopStack.push(value);
        }

        public int deleteHead() {
            if(firstTopStack.isEmpty()&& lastTopStack.isEmpty()){
                return -1;
            }
            while (!lastTopStack.isEmpty()) {
                firstTopStack.push(lastTopStack.pop());
            }
            return firstTopStack.pop();
        }
    }
}
