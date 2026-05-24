class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        f(0, nums, res, curr);
        return res;
    }

    private void f(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if(idx == nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[idx]);
        f(idx + 1, nums, res, curr);
        curr.remove(curr.size()-1);
        f(idx + 1, nums, res, curr);
    }
}
