class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def dfs(row, col):
            if row < 0 or col < 0:
                return 0
            if row == 0 or col == 0:
                return 1
            
            up = dfs(row-1, col)

            left = dfs(row, col-1)

            return up + left


        return dfs(m-1, n-1)