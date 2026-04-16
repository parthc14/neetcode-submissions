class Solution:
    def rob(self, nums: List[int]) -> int:
        memo = {}
        def rec (idx, nums):

            if idx == 0:
                return nums[0]

            if idx in memo:
                return memo[idx]

            skip = rec(idx-1, nums) + 0
            take = nums[idx]

            if idx > 1:
                take = rec(idx - 2, nums) + nums[idx]

            res = max(take, skip)
            memo[idx] = res
            return res

        return rec(len(nums)-1, nums)