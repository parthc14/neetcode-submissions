class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        
        res = 1
        seen = set()

        for num in nums:
            seen.add(num)
        
        local_max = 1
        for num in nums:
            prev_no = num - 1
            
            while prev_no in seen:
                local_max += 1
                prev_no -= 1
            res = max(res, local_max)
            local_max = 1
        return res