package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStack {
    int top;
    int MaxSize;
    int[] stack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayStack t = new ArrayStack(4);
        boolean loop = true;
        while (loop) {
            System.out.println("a:pop");
            System.out.println("b:push");
            System.out.println("s:show");
            System.out.println("e:end");
            switch (scanner.next().charAt(0)) {
                case 'a':
                    System.out.println("请输入:");
                    try {
                        t.pop(scanner.nextInt());
                    }catch (RuntimeException e){
                        System.out.println(e);
                    }//只throw的话就会弹出来让用户处理了
//                    但写了try catch的话就会按catch里面的方法处理，不会弹出来
                    break;
                case 'b':
                    try{
                        System.out.println(t.push());
                    }catch (RuntimeException e){
                        System.out.println(e);
                    }
                    break;
                case 's':
                    t.show();
                    break;
                case 'e':
                    loop = false;
                    System.out.println("已退出！");
                default:
                    break;
            }
        }
    }

    public void show() {
        System.out.println(Arrays.toString(stack));
    }

    public int push() {
        if (isEmpty()) {
            throw new RuntimeException("空栈！");
        } else {
            int num = stack[top];
            stack[top] = 0;
            top--;
            return num;
        }
    }

    public void pop(int num) {
        if (isFull()) {
            throw new RuntimeException("栈已满！");
        } else {
            top++;
            stack[top] = num;
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == MaxSize - 1;
    }

    public ArrayStack(int maxSize) {
        top = -1;
        MaxSize = maxSize;
        stack = new int[maxSize];
    }
}
