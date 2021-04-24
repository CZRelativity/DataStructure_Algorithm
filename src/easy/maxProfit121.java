package easy;

class maxProfit121 {
    public static void main(String[] args) {
        maxProfit121 t = new maxProfit121();
        t.test();
    }

    private void test() {
        int[][] eg = {{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}, {}, {1}};
        for (int[] e : eg) {
            System.out.println(maxProfit(e));
        }
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

    //只有一次机会，只需要一个前面的最小值和后面的最大值
    public int maxProfit(int[] prices) {
        int max = 0;
        int preMin = 10001;
        for (int price : prices) {
            max = Math.max(price - preMin, max);
            preMin = Math.min(price, preMin);
        }
        return max;
    }
}
