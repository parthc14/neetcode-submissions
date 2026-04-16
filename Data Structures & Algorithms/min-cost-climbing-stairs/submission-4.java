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
}
