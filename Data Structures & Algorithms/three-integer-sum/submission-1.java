class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> unique = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int third = - (nums[i] + nums[j]);
                if(seen.contains(third)) {
                    List<Integer> tempList = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(tempList);
                    unique.add(tempList);
                }
                seen.add(nums[j]);
            }
        }
        List<List<Integer>> triplets = new ArrayList<>(unique);
        return triplets;
    }
}
