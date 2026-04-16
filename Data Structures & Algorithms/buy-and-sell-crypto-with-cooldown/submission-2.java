class Solution {
    public int maxProfit(int[] prices) {
        return f(0, 0, prices);
    }

    public int f(int idx, int canSell, int[] prices) {
        if(idx >= prices.length) {
            return 0;
        }

        int profit = 0;

        if(canSell == 0) {
            int buy = - prices[idx] + f(idx + 1, 1, prices);
            int skipBuy = 0 + f(idx + 1, 0, prices);

            profit = Math.max(buy, skipBuy);
        }

        if(canSell == 1) {
            int sell = + prices[idx] + f(idx + 2, 0, prices);
            int skipSell = 0 + f(idx + 1, 1, prices);

            profit = Math.max(sell, skipSell);
        }

        return profit;
    }
}
