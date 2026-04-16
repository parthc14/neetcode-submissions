class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        memo = {}
        def dfs(i, j):
            # Base case
            if i >= len(text1) or j >= len(text2):
                return 0

            if (i,j) in memo:
                return memo[(i,j)]
            
            if text1[i] == text2[j]:
                res = dfs(i+1, j+1) + 1
                memo[(i,j)] = res
                return res

            skip_text1 = dfs(i+1, j)
            skip_text2 = dfs(i, j+1)
            res = max(skip_text1, skip_text2)
            memo[(i, j)] = res
            return res
            
        return dfs(0, 0)