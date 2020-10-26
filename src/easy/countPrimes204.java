package easy;

public class countPrimes204 {
    public static void main(String[] args){
        countPrimes204 t=new countPrimes204();
        int res= t.countPrimes(20);
        System.out.print(res);
    }

    //9%，妈的
    public int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int count=1;
        for(int num=3;num<n;num+=2){
            int factor=3;
            while (factor<=Math.sqrt(num)){
                if(num%factor==0){
                    break;
                }
                factor+=2;
            }
            if(factor>Math.sqrt(num)){
                ++count;
            }
        }
        return count;
    }

}
