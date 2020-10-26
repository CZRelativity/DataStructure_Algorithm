package easy;

public class maxProfit122 {
    public static void main(String[] args) {
        maxProfit122 t=new maxProfit122();
        int[] eg1=new int[]{7,1,5,3,6,4};
        int[] eg2=new int[]{1,2,3,4,5};
        int[] eg3=new int[]{7,6,4,3,1};
        int[] eg4=new int[]{2,1,2,0,1};
        int res= t.solve(eg4);
        System.out.println(res);
    }

    /**买卖股票的最佳时机Ⅱ（贪心算法）
     * 单独上涨，卖，不然就拿不到这次上涨的profit
     * 连续上涨，不卖，因为花一天时间重新买入就会错过这一天的上涨
     * 连续跌，不买！
     * @param prices 每日股价
     * @return 最大利润
     */
    private int solve(int[] prices){
        if(prices.length<2){
            return 0;
        }
        int profit=0;
        int buy=-1,today,tomorrow;
        for(int i=0;i<prices.length-1;i++){
            today=prices[i];
            tomorrow=prices[i+1];
            if(today<tomorrow&&buy==-1){
                buy=today;
            }else if(today>tomorrow&&buy!=-1){
                profit+=today-buy;
                buy=-1;
            }
        }
        if(buy!=-1){
            profit+=prices[prices.length-1]-buy;
        }
        return profit;
    }
}
