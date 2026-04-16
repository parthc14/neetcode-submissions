class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for(int num: nums) {
            total += num;
        }

        if(total % 2 == 1) return false;
        int n = nums.length;
        int target = (total / 2);
        int[][] dp = new int[n][target + 1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return f(n-1, target, nums, dp);
    }

    public boolean f(int idx, int target, int[] nums, int[][] dp) {
        if(target == 0) return true;

        if(idx == 0) {
            return target == nums[0];
        }

        boolean nonPick = f(idx-1, target, nums, dp);

        boolean pick = false;

        if(target >= nums[idx]) {
            pick = f(idx-1, target - nums[idx], nums, dp);
        }

        dp[idx][target] = pick || nonPick == true ? 1 : 0;

        return pick || nonPick;
    }


}
