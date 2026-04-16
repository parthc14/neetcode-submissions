class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        f(0, target, candidates, current, res);
        return res;
    }

    public void f(int startIdx, int target, int[] candidates, List<Integer> current, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList(current));
            return;
        }

        if(target < 0 || startIdx == candidates.length) {
            return;
        }

        current.add(candidates[startIdx]);
        f(startIdx, target - candidates[startIdx], candidates, current, res);

        current.remove(current.size() - 1);
        f(startIdx+1, target, candidates, current, res);
    }
}
