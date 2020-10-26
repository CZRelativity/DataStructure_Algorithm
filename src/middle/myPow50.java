package middle;

public class myPow50 {
    public static void main(String[] args){
        myPow50 t=new myPow50();
        int[] egN=new int[]{10,3,-2,3};
        double[] egX=new double[]{2,2.1,2,0};
        double res=t.solveOriginal(egX[0],egN[0]);
        System.out.println(res);
    }

    //二分思想，时间97%，这道题竟然没有溢出陷阱？
    public double solveOriginal(double x,int n){
        if(x==1||x==0){
            return x;
        }

        //负次幂，即倒数的正次幂
        if(n<0){
            x=1/x;
            n=-n;
        }
        return binaryPow(x,n);
    }

    public double binaryPow(double x,int n){
        //递归的退出条件，0次等于1，1次等于本身
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        int res=2;
        double curPow=x*x;

        //参考两数相除的二分逼近思想，在下次翻倍就会超出的时候退出迭代逼近
        while(n/2>res){
            curPow*=curPow;
            res+=res;
        }

        //幂运算的特点，对剩下的次数继续求幂，乘上之前结果，相当于次数的加
        curPow*=binaryPow(x,n-res);
        return curPow;
    }
}
