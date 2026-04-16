class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return 1
        memo = {}

        def dfs(idx, prevIdx):
            if idx == len(nums):
                return 0
            
            if (idx, prevIdx) in memo:
                return memo[(idx, prevIdx)]

            skip = 0 + dfs(idx+1, prevIdx)
            take = 0

            if prevIdx == -1 or nums[idx] > nums[prevIdx]:
                take = 1 + dfs(idx+1, idx)

            res = max(skip, take)
            memo[(idx, prevIdx)] = res
            return max(skip, take)

        return dfs(0, -1)
        
        