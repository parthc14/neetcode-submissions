class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int currentBest = 1;

            int nextNumber = nums[i] + 1;

            while(find(nextNumber, nums)) {
                nextNumber = nextNumber + 1;
                currentBest++;
            }

            longest = Math.max(longest, currentBest);
        }
        
        return longest;
    }

    public boolean find(int number, int[] nums) {
        for(int no: nums) {
            if(no == number) return true;
        }

        return false;
    }
}
