package easy;

public class isHappy202 {
    public static void main(String[] args){
        isHappy202 t=new isHappy202();
        int eg1=19;
        int eg2=10;
        int eg3=0;
        boolean result= t.solve(eg3);
        System.out.println(result);
    }

    //双指针变体，时间100%，内存81%
    public boolean solve(int num){
        int slow=num,fast=num;
        while(slow!=1&&fast!=1){
            slow=replace(slow);
            fast=replace(replace(fast));
            if(slow!=1&&slow==fast){
                return false;
            }
        }
        return true;
    }

    public int replace(int cur){
        int next=0;
        while(cur!=0){
            next+=(cur%10)*(cur%10);
            cur=cur/10;
        }
        return next;
    }
}
