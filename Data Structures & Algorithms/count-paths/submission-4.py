class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = {}

        def dfs(row, col):
            if row < 0 or col < 0:
                return 0
            if row == 0 or col == 0:
                return 1
            
            if (row, col) in memo:
                return memo[(row, col)]

            up = dfs(row-1, col)

            left = dfs(row, col-1)

            res = up + left
            memo[(row, col)] = res
            return res


        return dfs(m-1, n-1)