class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return 1

        def dfs(idx, prevIdx):
            if idx == len(nums):
                return 0
            
            skip = 0 + dfs(idx+1, prevIdx)
            
            take = 0

            if prevIdx == -1 or nums[idx] > nums[prevIdx]:
                take = 1 + dfs(idx+1, idx)
            return max(skip, take)

        return dfs(0, -1)
        
        