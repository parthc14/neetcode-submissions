class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:

        isDuplicate = False

        n = len(nums)

        if not nums:
            return isDuplicate

        if n == 1:
            return isDuplicate

        for i in range(len(nums)):

            for j in range(i+1, len(nums)):
                if nums[i] == nums[j]:
                    isDuplicate = True
                    break
        
        return isDuplicate
