class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def f(idx, curr_sum, curr, target):
            if curr_sum == target:
                res.append(curr[:])
                return
            
            if curr_sum > target or idx == len(candidates):
                return

            for i in range(idx + 1, len(candidates)):
                if candidates[i] != candidates[idx]:
                    f(i, curr_sum, curr, target)
                    break
            
            if curr_sum + candidates[idx] <= target:
                curr_sum += candidates[idx]
                curr.append(candidates[idx])
                f(idx + 1, curr_sum, curr, target)

                curr.pop()
                curr_sum -= candidates[idx]




        f(0, 0, [], target)
        return res