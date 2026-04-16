class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        return Math.min(f(n-1, cost, dp), f(n-2, cost, dp));
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
