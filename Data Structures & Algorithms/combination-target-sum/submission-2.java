class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generateSum(0, nums, target, curr, res);
        return res;
    }

    private void generateSum(int idx, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(target < 0 || idx == nums.length) return;

        curr.add(nums[idx]);
        generateSum(idx, nums, target - nums[idx], curr, res);

        curr.remove(curr.size()-1);
        generateSum(idx+1, nums, target, curr, res);
        
    }
}
