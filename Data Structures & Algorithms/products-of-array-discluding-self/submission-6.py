class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        if not nums:
            return []

        n = len(nums)

        prefix_arr, suffix_arr, res = [0] * n, [0] * n, [0] * n
        prefix_arr[0], suffix_arr[n-1] = 1, 1 
        for i in range(1, n):
            prefix_arr[i] = prefix_arr[i-1] * nums[i-1]
        
        for i in range(n-2, -1, -1):
            suffix_arr[i] = suffix_arr[i+1] * nums[i+1]
        
        for i, _ in enumerate(nums):
            res[i] = prefix_arr[i] * suffix_arr[i]
        
        return res



        
        