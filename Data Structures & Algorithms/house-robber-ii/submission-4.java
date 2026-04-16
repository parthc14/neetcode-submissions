class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        // arr1 consist of skipped 1st el
        int[] arr1 = new int[n-1];
        // arr2 consist of skipped last el
        int[] arr2 = new int[n-1];
        for(int i=0; i<n; i++) {
            if(i != 0) {
                arr1[i-1] = nums[i];
            }

            if(i != n-1) {
                arr2[i] = nums[i];
            }
        }

        int dp1 = f(arr1);
        int dp2 = f(arr2);

        return Math.max(dp1, dp2);
    }

    public int f(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1; i<n; i++) {
            int skip = dp[i-1];

            int take = nums[i];
            if(i > 1) {
                take = dp[i-2] + nums[i];
            }

            dp[i] = Math.max(take, skip);
        }

        return dp[n-1];
    }
}
