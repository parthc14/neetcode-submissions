class Solution:
    def numDecodings(self, s: str) -> int:
        memo = {}
        n = len(s)
        
        memo[n] = 1
        for i in range(n-1, -1, -1):
            if s[i] == '0':
                memo[i] = 0
                continue
            memo[i] = memo[i+1]

            if i < n-1 and (s[i] == '1' or (s[i] == '2' and s[i+1] < '7')):
                memo[i] += memo[i+2]
        
        return memo[0]

        # def dfs(i):
        #     if i == len(s):
        #         return 1
        #     if s[i] == '0':
        #         return 0

        #     if i in memo:
        #         return memo[i]
            
        #     res = dfs(i+1)

        #     if i < len(s) - 1:
        #         if (s[i] == '1' or (s[i] == '2' and s[i+1] < '7')):
        #             res += dfs(i+2)

        #     memo[i] = res
        #     return res
        # return dfs(0)