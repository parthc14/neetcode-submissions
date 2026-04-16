class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return 1
        
        max_so_far = 1

        nums.sort()
        local = 1
        for i in range(len(nums)-1):
            if nums[i+1] - nums[i] == 1:
                local += 1
                max_so_far = max(max_so_far, local)
            
            elif nums[i+1] - nums[i] > 1:
                local = 1
                continue

        return max_so_far

        