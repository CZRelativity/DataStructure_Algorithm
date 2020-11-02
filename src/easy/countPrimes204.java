package easy;

import java.util.Arrays;

public class countPrimes204 {
    public static void main(String[] args){
        countPrimes204 t=new countPrimes204();
        int res= t.countPrimesImprove(20);
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

    /* Sieve of Eratosthenes 厄拉多塞筛
    * 竟然不需要判断质数，我？！只用排除，所谓筛 */
    private int countPrimesImprove(int n){
        boolean[] isPrime=new boolean[n];
        //Arrays和Collections都有很多好用的方法
        Arrays.fill(isPrime,true);
        //只需要判断到sqrt(n)，因为sqrt(n)以上都被sqrt(n)以下的平方覆盖了
        for(int factor=2;factor*factor<n;factor++){
            if(isPrime[factor]){
                //质数的所有整数倍全部排除
                for(int i=factor*factor;i<n;i+=factor){
                    isPrime[i]=false;
                }
            }
        }
        int count=0;
        //在这里排除了0 1
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}
