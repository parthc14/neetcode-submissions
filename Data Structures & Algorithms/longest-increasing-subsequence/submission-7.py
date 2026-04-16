class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        
        # DP array
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        
        # Fill the DP table
        for i in range(n - 1, -1, -1):
            for prevInd in range(i - 1, -2, -1):
                # Not Take case
                notTake = dp[i + 1][prevInd + 1]
                
                # Take case
                take = 0
                
                # Check for the Take case
                if prevInd == -1 or nums[i] > nums[prevInd]:
                    take = dp[i + 1][i + 1] + 1
                
                # Store the maximum of the two cases
                dp[i][prevInd + 1] = max(take, notTake)
        
        # Return the stored result
        return dp[0][0]
        
        