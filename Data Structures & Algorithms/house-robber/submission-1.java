class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(n-1, nums, dp);
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
