class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        calculateCombinationSum(0, candidates, target, curr, res);
        return res;   
    }

    private void calculateCombinationSum(int startIdx, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || startIdx == nums.length) return;

        curr.add(nums[startIdx]);
        calculateCombinationSum(startIdx + 1, nums, target - nums[startIdx], curr, res);

        curr.remove(curr.size()-1);

        for(int i=startIdx+1; i<nums.length; i++) {
            if(nums[i] != nums[startIdx]) {
                calculateCombinationSum(i, nums, target, curr, res);
                break;
            }
        }
        calculateCombinationSum(nums.length, nums, target, curr, res);

    }
}
