class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        res = 1
        local_max = 1
        nums.sort()
        n = len(nums)
        for i in range(n-1):
            if nums[i+1] - nums[i] == 1:
                local_max += 1
                res = max(res, local_max)
            elif nums[i+1] - nums[i] == 0:
                continue
            else:
                local_max = 1
        
        return res
