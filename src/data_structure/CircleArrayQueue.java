package data_structure;

import java.util.Arrays;
import java.util.Scanner;

public class CircleArrayQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
                    queue.showQueue();
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

    int rear;
    int front;
    int[] arr;
    int maxSize;

    public CircleArrayQueue(int maxSize) {
        this.maxSize=maxSize;
        rear = 0;
        front = 0;
        arr = new int[maxSize];
    }

    void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        } else {
            arr[rear] = num;//rear指向最后一个元素后面预留的一个位置，所以可以直接放进去
//            rear = (rear + 1) % maxSize;//?
            rear++;
        }
    }

    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        } else {
            int out = arr[front];//front永远指向第一个元素的位置，所以可以直接取出来
//            front = (front + 1) % maxSize;
            if (rear - 1 >= 0) System.arraycopy(arr, 1, arr, 0, rear - 1);
            arr[rear-1]=0;
            rear--;
            //****手动copy_array到自动copy_array,这是一个native方法，意思底层是用C++实现的
//            parameter:Object src,原数组,int srcPos,原数组位置,Object dest(destination),目标数组,int destPos,
//            目标位置,int length,长度
            return out;
        }
    }

    int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        } else {
            return arr[front];
        }
    }

    int getSize() {
//        return (rear + maxSize - front) % maxSize;
        return rear;
    }

    void showQueue() {
        System.out.println(Arrays.toString(arr));
    }

    boolean isFull() {
//        return (rear+1) % maxSize == front;//?
        return rear==maxSize;
    }

    boolean isEmpty() {
        return rear == front;
    }
}
