class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;
        int noOfZeros = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                product *= nums[i];
            } else {
                noOfZeros++;
            }
        }

        if(noOfZeros > 1) return ans;

        for(int i=0; i<n; i++) {
            if(noOfZeros == 0) {
                ans[i] = product / nums[i];
            } else if(nums[i] == 0) {
                ans[i] = product;
            }
        }

        return ans;
    }
}  
