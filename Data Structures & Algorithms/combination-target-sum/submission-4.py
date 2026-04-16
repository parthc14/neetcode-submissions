class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        def f(idx, curr_sum, curr):
            if curr_sum == target:
                res.append(curr[:])
                return

            if curr_sum > target or idx == len(nums):
                return
            
            
            f(idx + 1, curr_sum, curr)

            if nums[idx] + curr_sum <= target:
                curr_sum += nums[idx]
                curr.append(nums[idx])
                f(idx, curr_sum, curr)
                curr.pop()
                curr_sum -= nums[idx]


        f(0, 0, [])
        return res
        