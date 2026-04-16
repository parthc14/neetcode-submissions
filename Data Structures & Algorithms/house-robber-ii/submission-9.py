class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        nums1, nums2 = nums[:n-1], nums[1:]

        def rober(nums: List[int]) -> int:
            memo = {}

            def rec(idx, nums):

                if idx == 0:
                    return nums[0]

                if idx in memo:
                    return memo[idx]

                skip = rec(idx-1, nums) 
                take = nums[idx]

                if idx > 1:
                    take = rec(idx - 2, nums) + nums[idx]

                res = max(take, skip)
                memo[idx] = res
                return res

            return rec(len(nums)-1, nums)

        return max(rober(nums1), rober(nums2))
    

    