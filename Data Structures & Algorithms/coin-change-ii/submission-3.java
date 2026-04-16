class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[coins.length][amount + 1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return f(n-1, amount, coins, dp);
    }

    private int f(int startIdx, int amount, int[] coins, int[][] dp) {
        if(amount < 0 || startIdx < 0) {
            return 0;
        }
        if(amount == 0) return 1;

        if(dp[startIdx][amount] != -1) {
            return dp[startIdx][amount];
        }

        int take = f(startIdx, amount - coins[startIdx], coins, dp);
        int skip = f(startIdx - 1, amount, coins, dp);
        return dp[startIdx][amount] = take + skip;
    }
}
