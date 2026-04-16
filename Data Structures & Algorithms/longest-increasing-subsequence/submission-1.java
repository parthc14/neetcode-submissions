class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, dp);
    }

    public int f(int idx, int prev, int[] nums, int[][] dp) {
        if(idx == nums.length - 1) {
            if(prev == -1 || nums[idx] > nums[prev]) return 1;
            return 0;
        }

        if(dp[idx][prev+1] != -1) {
            return dp[idx][prev+1];
        }

        int notTake = f(idx + 1, prev, nums, dp);
        int take = 0;

        if(prev == -1 || nums[idx] > nums[prev]) {
            take = f(idx + 1, idx, nums, dp) + 1;
        }

        return dp[idx][prev+1] = Math.max(take, notTake);
    }
}
