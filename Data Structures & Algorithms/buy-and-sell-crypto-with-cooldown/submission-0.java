class Solution {
    public int maxProfit(int[] prices) {
        return f(0, 1, prices);
    }

    public int f(int idx, int canBuy, int[] prices) {
        if(idx >= prices.length) {
            return 0;
        }

        int profit = 0;

        if(canBuy == 1) {
            int buy = - prices[idx] + f(idx + 1, 0, prices);
            int skipBuy = 0 + f(idx + 1, 1, prices);

            profit = Math.max(buy, skipBuy);
        }

        if(canBuy == 0) {
            int sell = + prices[idx] + f(idx + 2, 1, prices);
            int skipSell = 0 + f(idx + 1, 0, prices);

            profit = Math.max(sell, skipSell);
        }

        return profit;
    }
}
