class Solution {
    int maxCost = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        for(int i=1; i<= amount; i++) {
            dp[n][i] = maxCost;
        }

        for(int startIdx = n-1; startIdx >= 0; startIdx--) {
            for(int amnt = 1; amnt<=amount; amnt++) {
                int skip = dp[startIdx + 1][amnt];
                int take = maxCost;

                if(amnt - coins[startIdx] >= 0 && dp[startIdx][amnt - coins[startIdx]] != maxCost) {
                    take = 1 + dp[startIdx][amnt - coins[startIdx]];
                }
                

                dp[startIdx][amnt] = Math.min(take, skip);
            }
        }
        
        int cost = dp[0][amount];
        return cost >= maxCost ? -1 : cost;  
    }
}
