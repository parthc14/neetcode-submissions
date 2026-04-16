class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        no_of_islands = 0
        
        if not grid:
            return no_of_islands
        
        n = len(grid)
        m = len(grid[0])

        directions = [[0,1], [1,0], [0,-1], [-1,0]]

        def isValid(row, col):
            return 0 <= row < n and 0 <= col < m

        def dfs(row, col):
            
            grid[row][col] = ""

            for dir in directions:
                nRow = dir[0] + row
                nCol = dir[1] + col

                if isValid(nRow, nCol) and grid[nRow][nCol] != "" and grid[nRow][nCol] == "1":
                    dfs(nRow, nCol)
                


        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    no_of_islands += 1
                    dfs(i, j)
        
        return no_of_islands
