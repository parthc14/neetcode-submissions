class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return 1
        
        max_so_far = 1
        local = 1
        
        seen = set()

        for num in nums:
            seen.add(num)

        for num in nums:
            prev_no = num - 1
            while prev_no in seen:
                prev_no -= 1
                local += 1

            max_so_far = max(max_so_far, local)
            local = 1
        
        return max_so_far

        