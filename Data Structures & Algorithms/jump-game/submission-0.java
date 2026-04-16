class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpIdx = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(i > maxJumpIdx) return false;
            maxJumpIdx = Math.max(maxJumpIdx, nums[i] + i);
        }

        return true;   
    }
}
