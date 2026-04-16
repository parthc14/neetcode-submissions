class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);
        generateSubsets(0, nums, curr, res);
        return res;
    }

    private void generateSubsets(int startIdx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if(startIdx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[startIdx]);
        generateSubsets(startIdx + 1, nums, curr, res);

        curr.remove(curr.size()-1);

        for(int i=startIdx + 1; i<nums.length; i++) {
            if(nums[i] != nums[startIdx]) {
                generateSubsets(i, nums, curr, res);
                return;
            }
        }

        generateSubsets(nums.length, nums, curr, res);
        
    }
}
