class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        nums1, nums2 = nums[:n-1], nums[1:]

        def rober(nums: List[int]) -> int:
            n = len(nums)
            dp = [0] * n
            dp[n-1] = nums[n-1]

            for idx in range(n - 2, -1, -1):
                take = nums[idx]

                skip = dp[idx+1] 

                if idx + 2 <= n-1:
                    take = dp[idx+2] + nums[idx]

                dp[idx] = max(take, skip)

            return dp[0]
            

        return max(rober(nums1), rober(nums2))
    

    