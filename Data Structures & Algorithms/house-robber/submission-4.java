class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1; i<n; i++) {
            int skip = dp[i-1];
            int take = nums[i];

            if(i > 1) {
                take = dp[i - 2] + nums[i];
            }
            dp[i] = Math.max(take, skip);
        }

        return dp[n-1];
    }

    public int f(int startIdx, int[] nums, int[] dp) {
        if(startIdx == 0) return nums[0];

        if(startIdx < 0) return 0;

        if(dp[startIdx] != -1) {
            return dp[startIdx];
        }

        int take = f(startIdx-2, nums, dp) + nums[startIdx];
        int skip = f(startIdx -1, nums, dp) + 0;

        return dp[startIdx] = Math.max(take, skip); 
    }
}
