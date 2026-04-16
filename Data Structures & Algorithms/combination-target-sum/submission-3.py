class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def f(idx, curr, target):
            if target < 0 or idx == len(nums):
                return
            
            if target == 0:
                res.append(curr[:])
                return

            curr.append(nums[idx])
            f(idx, curr, target - nums[idx])

            curr.pop()
            f(idx + 1, curr, target)

        f(0, [], target)

        return res