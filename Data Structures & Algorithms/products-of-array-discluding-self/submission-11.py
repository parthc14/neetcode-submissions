class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)

        prefix, suffix = 1, 1
        n = len(nums)

        res[0] = prefix

        for i in range(1, n):
            prefix*= nums[i-1]
            res[i] = prefix

        for j in range(n-2, -1, -1):
            suffix *= nums[j+1]
            res[j]*= suffix
    
        return res