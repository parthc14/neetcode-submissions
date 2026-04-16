class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] isNumberPicked = new boolean[nums.length];
        generate(0, nums, currentPermutation, permutations, isNumberPicked);
        return permutations;
    }

    private void generate(int startIdx, int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] isPicked) {
        // Base case
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!isPicked[i]) {
                curr.add(nums[i]);
                isPicked[i] = true;
                generate(i+1, nums, curr, res, isPicked);
                curr.remove(curr.size()-1);
                isPicked[i] = false;
            }
        }
    }
}
