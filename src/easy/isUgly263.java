package easy;

public class isUgly263 {
    public static void main(String[] args) {
        isUgly263 t=new isUgly263();
        int eg1=6;
        int eg2=8;
        int eg3=14;
        boolean res=t.isUgly(eg3);
        System.out.print(res);
    }

    //时间100%
    public boolean isUgly(int num) {
        if(num==0){
            return false;
        }
        while(true){
            if(num%2==0){
                num/=2;
            }else if(num%3==0){
                num/=3;
            }else if(num%5==0){
                num/=5;
            }else {
                //1是丑数！！！
                return num == 1;
            }
        }
    }
}
