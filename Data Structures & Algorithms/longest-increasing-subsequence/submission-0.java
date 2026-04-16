class Solution {
    public int lengthOfLIS(int[] nums) {
        return f(0, -1, nums);
    }

    public int f(int idx, int prev, int[] nums) {
        if(idx == nums.length - 1) {
            if(prev == -1 || nums[idx] > nums[prev]) return 1;
            return 0;
        }

        int notTake = f(idx + 1, prev, nums);
        int take = 0;

        if(prev == -1 || nums[idx] > nums[prev]) {
            take = f(idx + 1, idx, nums) + 1;
        }

        return Math.max(take, notTake);
    }
}
