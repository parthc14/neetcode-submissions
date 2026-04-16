class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i=0; i<nums.length; i++) {
            int localSum = 0;

            for(int j = i; j<n; j++) {
                localSum += nums[j];
                maxSum = Math.max(maxSum, localSum);
            }
        }

        return maxSum;
    }
}
