class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for(int num: nums) {
            total += num;
        }

        if(total % 2 == 1) return false;
        int n = nums.length;
        int target = (total / 2);
        return f(n-1, target, nums);
    }

    public boolean f(int idx, int target, int[] nums) {
        if(target == 0) return true;

        if(idx == 0) {
            return target == nums[0];
        }

        boolean skip = f(idx -1, target, nums);
        boolean take = f(idx-1, target - nums[idx], nums);

        return skip || take;
    }


}
