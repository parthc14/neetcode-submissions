class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        if not nums:
            return []

        n = len(nums)

        res = [0] * n
        prefix = 1
        res[0], res[n-1] = 1, 1
        for i in range(1, n):
            prefix *= nums[i-1]
            res[i] = prefix
        suffix = 1

        for i in range(n-2, -1, -1):
            suffix *= nums[i+1]

            res[i] *= suffix

        return res



        
        