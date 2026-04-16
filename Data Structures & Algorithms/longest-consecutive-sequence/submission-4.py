class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        def find(next_no: int) -> bool:
            for n in nums:
                if n == next_no:
                    return True
            return False


        max_len = 1
        for num in nums:
            curr = num
            curr_len = 1
            
            while find(curr + 1):
                curr_len += 1
                curr +=1
            max_len = max(max_len, curr_len)

        return max_len

        

"""
Input: nums = [2,20,4,10,3,4,5]
               0
"""