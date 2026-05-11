class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        res = [0] * len(nums)

        zero_cnt = 0
        prod = 1

        for num in nums:
            if num == 0:
                zero_cnt += 1
            else:
                prod *= num
        
        if zero_cnt > 1:
            return res
        
        for i in range(len(nums)):
            if nums[i] == 0:
                res[i] = prod
            elif zero_cnt == 1:
                continue
            else:
                res[i] = prod // nums[i]
        
        return res
            