class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n = len(text1)
        m = len(text2)
        
        dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                if text1[i] == text2[j]:
                    dp[i][j] = 1 + dp[i+1][j+1]
                else:
                    skip_text1 = dp[i+1][j]
                    skip_text2 = dp[i][j+1]

                    dp[i][j] = max(skip_text1, skip_text2)
        
        return dp[0][0]
        