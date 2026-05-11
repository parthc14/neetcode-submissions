class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res, suffix_arr, prefix_arr = [0] * len(nums), [0] * len(nums), [0] * len(nums)

        prefix_arr[0], suffix_arr[len(nums)-1] = 1, 1
        n = len(nums)
        for i in range(1, n):
            prefix_arr[i] = prefix_arr[i-1] * nums[i-1]
        
        for j in range(n-2, -1, -1):
            suffix_arr[j] = suffix_arr[j+1] * nums[j+1]

        for k in range(n):
            res[k] = prefix_arr[k] * suffix_arr[k]
        
        return res
