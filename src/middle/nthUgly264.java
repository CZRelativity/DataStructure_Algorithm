package middle;

public class nthUgly264 {
    public static void main(String[] args) {
        nthUgly264 t = new nthUgly264();
        int res = t.nthUglyNumber(10);
        System.out.print(res);
    }

//    List<Integer> uglyList=new ArrayList<>();
//
//    public nthUgly264(){
//        for(int v5=1;v5<Integer.MAX_VALUE/5;v5*=5){
//            for(int v3=v5;v3<Integer.MAX_VALUE/3;v3*=3){
//                for(int v2=v3;v2<Integer.MAX_VALUE/2;v2*=2){
//                    uglyList.add(v2);
//                    if(uglyList.size()==1690){
//                        break;
//                    }
//                }
//            }
//        }
//        Collections.sort(uglyList);
//    }
//
//    public int nthUglyNumber(int n) {
//        return uglyList.get(n-1);
//    }

    /* dp方法，就是妙，自动排序，完美去重，还简单
    * 应该说这道题都会有积累误差？的存在，越往后2的倍数跟5的倍数差距越来越大
    * 所以说才限制了n的最大值 */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            //要排序可能有问题，但是只是求个最小值没问题
            dp[i] = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            if(dp[i]==dp[p2]*2){
                ++p2;
            }
            if(dp[i]==dp[p3]*3){
                ++p3;
            }
            if(dp[i]==dp[p5]*5){
                ++p5;
            }
        }
        return dp[n-1];
    }
}
