class Solution {
    int maxCost = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int cost = f(0, coins, amount, dp);
        return cost == maxCost ? -1 : cost;  
    }

    public int f(int startIdx, int[] coins, int target, int[][] dp) {
        if(target < 0 || startIdx == coins.length) return maxCost;

        if(target == 0) return 0;

        if(dp[startIdx][target] != -1) {
            return dp[startIdx][target];
        }

        int take = 1 + f(startIdx, coins, target - coins[startIdx], dp);
        int skip = 0 + f(startIdx + 1, coins, target, dp);


        return dp[startIdx][target] = Math.min(take, skip);
    }
}
