class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0
        
        if len(s) == 1:
            return 1
        
        n = len(s)
        cnt = 0

        dp = [[False] * n for _ in range(n)]
        
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and ((j - i <= 2) or dp[i+1][j-1]):
                    dp[i][j] = True
                    cnt += 1

            
        return cnt