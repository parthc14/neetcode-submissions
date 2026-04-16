class Solution {
    public int jump(int[] nums) {
        return f(0, 0, nums);
    }

    public int f(int idx, int jumps, int[] nums) {
        if(idx >= nums.length -1) return jumps;

        int mini = Integer.MAX_VALUE;

        for(int i=1; i<= nums[idx]; i++) {
            mini = Math.min(mini, f(idx + i, jumps + 1, nums));
        }
        
        return mini;
    } 
}

// [2,4,1,1,1,1]
//  0