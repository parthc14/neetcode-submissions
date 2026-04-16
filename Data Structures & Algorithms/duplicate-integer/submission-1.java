class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        for(int i =0; i<n; i++) {
            boolean exists = false;

            for(int j=i+1; j<n; j++) {
                if(nums[j] == nums[i]) {
                    exists = true;
                }
            }

            if(exists) return true;
        }

        return false;
    }
}