class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generateSubsets(0, nums, res, current);
        return res;
    }

    private void generateSubsets(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        generateSubsets(idx+1, nums,res, curr);

        curr.remove(curr.size() - 1);
        generateSubsets(idx+1, nums,res, curr);
    }
}
