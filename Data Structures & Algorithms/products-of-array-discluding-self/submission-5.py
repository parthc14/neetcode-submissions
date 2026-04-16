class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        if not nums:
            return []

        n = len(nums)

        res = [0] * n
        product = 1
        zero_cnt = 0
        for num in nums:
            if num == 0:
                zero_cnt += 1
            else:
                product *= num
        
        if zero_cnt > 1:
            return res
        
        for idx, val in enumerate(nums):
            if zero_cnt == 1:
                if val == 0:
                    res[idx] = product
            else:
                res[idx] = product // nums[idx]
        
        return res



        
        