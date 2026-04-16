class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            int diff = target - nums[i];
            if(countMap.containsKey(diff)) {
                return new int[]{countMap.get(diff), i};
            } else {
                countMap.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
