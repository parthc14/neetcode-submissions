class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int idx = n-1; idx >= 0; idx --) {
            for(int canSell = 0; canSell <= 1; canSell ++) {
                int profit = 0;
                if(canSell == 0) {
                    int buy = - prices[idx] + dp[idx+1][1];
                    int skipBuy = 0 + dp[idx+1][0];
                    profit = Math.max(buy, skipBuy);
                }

                if(canSell == 1) {
                    int sell = prices[idx] + dp[idx + 2][0];
                    
                    int skipSell = dp[idx +1][1];
                    profit = Math.max(sell, skipSell);
                }
                dp[idx][canSell] = profit;
            }
        }
        
        return dp[0][0];
    }

    public int f(int idx, int canSell, int[] prices, int[][] dp) {
        if(idx >= prices.length) {
            return 0;
        }

        if(dp[idx][canSell] != -1) {
            return dp[idx][canSell];
        }

        int profit = 0;

        if(canSell == 0) {
            int buy = - prices[idx] + f(idx + 1, 1, prices, dp);
            int skipBuy = 0 + f(idx + 1, 0, prices, dp);

            profit = Math.max(buy, skipBuy);
        }

        if(canSell == 1) {
            int sell = + prices[idx] + f(idx + 2, 0, prices, dp);
            int skipSell = 0 + f(idx + 1, 1, prices, dp);

            profit = Math.max(sell, skipSell);
        }

        return dp[idx][canSell] = profit;
    }
}
