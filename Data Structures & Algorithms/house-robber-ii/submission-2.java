class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        for(int i=0; i<n-1; i++) {
            arr2[i] = nums[i];
        }

        for(int i=1; i<n; i++) {
            arr1[i-1] = nums[i];
        }

        return Math.max(f(arr2.length-1, arr2, dp2), f(arr1.length-1, arr1, dp1));
    }

    public int f(int startIdx, int[] nums, int[] dp) {
        if(startIdx == 0) return nums[startIdx];

        if(startIdx < 0) return 0;

        if(dp[startIdx] != -1) {
            return dp[startIdx];
        }

        int skip = f(startIdx - 1, nums, dp);

        int take = f(startIdx -2, nums, dp) + nums[startIdx];

        return dp[startIdx] = Math.max(take, skip);
    }
}
