package easy;

public class maxProfit121 {
    public static void main(String[] args) {
        maxProfit121 t = new maxProfit121();
        int[] eg1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] eg2 = new int[]{7, 6, 4, 3, 1};
        int[] eg3 = new int[]{};
        int[] eg4 = new int[]{1};
        int res = t.solve(eg3);
        System.out.println(res);
    }

    private int solve(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        int curPrice;
        for (int i = 1; i < prices.length; i++) {
            curPrice = prices[i];
            if (curPrice < minPrice) {
                minPrice = curPrice;
            } else {
                if (curPrice - minPrice > profit) {
                    profit = curPrice - minPrice;
                }
            }
        }
        return profit;
    }
}
