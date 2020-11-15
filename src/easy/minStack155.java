package easy;

import java.util.ArrayList;
import java.util.List;

public class minStack155 {
    public static void main(String[] args){
        minStack155 t=new minStack155();
        t.test();
    }

    private void test(){
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin());
        pop();
        System.out.println(top());
        System.out.println(getMin());
    }

    List<Integer> stack;
    int min;

    /** initialize your data structure here.
     * 时间97% */
    public minStack155() {
        stack=new ArrayList<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.add(x);
        if(x<min){
            min=x;
        }
    }

    public void pop() {
        int p=stack.remove(stack.size()-1);
        if(p==min){
            min=Integer.MAX_VALUE;
            for(int i:stack){
                if(i<min){
                    min=i;
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return min;
    }
}
