class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return f(0, 1, prices, dp);
    }

    public int f(int idx, int canBuy, int[] prices, int[][] dp) {
        if(idx >= prices.length) {
            return 0;
        }

        int profit = 0;

        if(dp[idx][canBuy] != -1) {
            return dp[idx][canBuy];
        }

        if(canBuy == 1) {
            int buy = - prices[idx] + f(idx + 1, 0, prices, dp);
            int skipBuy = 0 + f(idx + 1, 1, prices, dp);

            profit = Math.max(buy, skipBuy);
        }

        if(canBuy == 0) {
            int sell = + prices[idx] + f(idx + 2, 1, prices, dp);
            int skipSell = 0 + f(idx + 1, 0, prices, dp);

            profit = Math.max(sell, skipSell);
        }

        return dp[idx][canBuy] = profit;
    }
}
