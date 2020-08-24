package data_structure;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        while (loop) {
            System.out.println("a:add");
            System.out.println("g:get");
            System.out.println("s:show");
            System.out.println("h:head");
            System.out.println("e:end");
            switch (scanner.next().charAt(0)) {
                case 'a':
                    System.out.println("请输入一个数：");
                    try {
                        queue.addQueue(scanner.nextInt());
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("取到:" + queue.getQueue());
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    break;
                case 's':
                    queue.show();
                    break;
                case 'h':
                    try {
                        System.out.println("队列头：" + queue.getHead());
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    break;
                case 'e':
                    loop = false;
                    System.out.println("已退出");
                    break;
                default:
                    break;
            }
        }
    }

    int maxSize;
    int front;
    int rear;
    int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return rear == (maxSize - 1);
    }

    boolean isEmpty() {
        return front == rear;
    }

    void addQueue(int out) {
        if (isFull()) throw new RuntimeException("队列已满！");
        else {
            rear++;
            arr[rear] = out;
        }
    }

    int getQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空！");
        else {
            front++;
            return arr[front];
        }
    }

    int getHead() {
        if (isEmpty()) throw new RuntimeException("队列为空！");
        else {
            return arr[front + 1];
        }
    }

    void show() {
        System.out.println(Arrays.toString(arr));
    }
}
