package middle;

public class numSquares279 {
    public static void main(String[] args){
        numSquares279 t=new numSquares279();
        t.test();
    }

    private void test(){
        int[] eg={1,12,13};
        for(int e:eg){
            System.out.println(numSquares(e));
        }
    }

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        //先把所有dp值置为最坏情况，再优化
        for(int i=0;i<n+1;i++){
            dp[i]=i;
        }
        /* 按照完全背包问题来看，1,4,16等完全平方数是要往里面放的物品，每个数的value都等于1，也就是数的个数
        * 每个数的值就是weight，总的value就是dp的值，即总个数 */

        /* 由此可总结出完全背包问题的模板 */
        for(int i=0;i<n+1;i++){
            for(int j=2;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

/*
        for(int weight=0;weight<=size;weight++){
            for(int item=0;item<=kinds;item++){
                dp[weight]=Math.max(dp[weight],dp[weight-weight(item)]+value(item));
            }
        }
*/

        return dp[n];
    }
}
