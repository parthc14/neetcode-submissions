class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        n = len(nums)
        memo = {}

        if n == 1:
            return 1
        
        def dfs(idx, prev):
            if idx == len(nums) - 1:
                if prev == -1 or nums[idx] > nums[prev]:
                    return 1
                return 0
            
            if (idx, prev) in memo:
                return memo[(idx, prev)]
            
            skip = dfs(idx+1, prev) + 0
            take = 0

            if prev == -1 or nums[idx] > nums[prev]:
                take = dfs(idx + 1, idx) + 1
            res = max(skip, take)
            memo[(idx, prev)] = res
            return res

        return dfs(0, -1)