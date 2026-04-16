class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[coins.length][amount + 1];

        for(int i=0; i<n; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=amount; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1: 0;
        }

        for(int startIdx = 1; startIdx < n; startIdx++) {
            for(int amnt = 1; amnt <= amount; amnt++) {
                int skip = dp[startIdx - 1][amnt];
                int take = 0;
                if(amnt - coins[startIdx] >= 0) {
                    take = dp[startIdx][amnt - coins[startIdx]];
                }

                dp[startIdx][amnt] = take + skip;
            }
        }

        return dp[n-1][amount];
    }
}
