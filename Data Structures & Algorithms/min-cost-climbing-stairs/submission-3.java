class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int startIdx = 2; startIdx < n; startIdx++) {
            int step1 = dp[startIdx -1]+ cost[startIdx];
            int step2 = dp[startIdx - 2] + cost[startIdx];

            dp[startIdx] = Math.min(step1, step2);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    private int f(int startIdx, int[] cost, int[] dp) {
        if(startIdx == 0 || startIdx == 1) return cost[startIdx];

        if(startIdx < 0) return (int) 1e9;

        if(dp[startIdx]!= -1){
            return dp[startIdx];
        }

        int step1 = f(startIdx -1, cost, dp) + cost[startIdx];
        int step2 = f(startIdx - 2, cost, dp) + cost[startIdx];

        return dp[startIdx] = Math.min(step1, step2);
    }
}
