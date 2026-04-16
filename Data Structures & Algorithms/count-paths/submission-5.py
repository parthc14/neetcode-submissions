class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = {}

        dp = [[0 for _ in range(n)] for _ in range(m)]

        for i in range(m):
            dp[i][0] = 1
        
        for i in range(n):
            dp[0][i] = 1
        
        for row in range(1, m):
            for col in range(1, n):
                up = dp[row-1][col]
                left = dp[row][col-1]

                dp[row][col] = up + left
        
        return dp[m-1][n-1]
