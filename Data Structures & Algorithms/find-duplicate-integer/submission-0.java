class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        int repeatedNumber = -1;
        for(int i=1; i<=n; i++) {
            int count = 0;

            for(int j=0; j<n; j++) {
                if(nums[j] == i) {
                    count++;
                }
            }

            if(count > 1){
                repeatedNumber = i;
                break;
            }
        }

        return repeatedNumber;
    }
}
