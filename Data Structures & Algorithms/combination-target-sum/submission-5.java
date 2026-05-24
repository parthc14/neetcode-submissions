class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList();
        Arrays.sort(nums);

        f(0, nums, 0, target, res, curr);
        return res;
    }

    private void f(int idx, int[] nums, int sum, int target, List<List<Integer>> res, List<Integer> curr){
        if(idx == nums.length || sum > target){
            return;
        }

        if(sum == target){
            res.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[idx]);
        f(idx, nums, sum + nums[idx], target, res, curr);
        curr.remove(curr.size()-1);
        f(idx +1, nums, sum, target, res, curr);
    }
}
