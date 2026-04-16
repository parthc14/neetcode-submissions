class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return 1
        
        max_so_far = 0

        def find(no):
            for num in nums:
                if no == num:
                    return True
            return False

        for num in nums:
            local = 1

            while find(num+1):
                local += 1
                num += 1
            
            max_so_far = max(max_so_far, local)
        
        return max_so_far

        