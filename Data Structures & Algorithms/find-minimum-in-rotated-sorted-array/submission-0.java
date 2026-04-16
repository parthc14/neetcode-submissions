class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;
            
            if(nums[mid] < min) {
                min = nums[mid];
            }

            if(nums[low] <= nums[mid]) {
                if(nums[low] < min) {
                    min = nums[low];
                }

                low = mid + 1;
            } else {
                if(nums[mid] <= nums[high]) {
                    if(nums[mid] < min) {
                        min = nums[mid];
                    }
                }
                high = mid - 1;
            }
        }

        return min;
    }
}
