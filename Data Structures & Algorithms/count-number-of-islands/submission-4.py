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

        def bfs(row, col):
            q = deque([])
            q.append((row, col))

            while len(q):

                r, c = q.popleft()

                grid[r][c] = "0"

                for dir in directions:
                    nRow = r + dir[0]
                    nCol = c + dir[1]

                    if isValid(nRow, nCol) and grid[nRow][nCol] != "0":
                        q.append((nRow, nCol))
            


        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    no_of_islands += 1
                    
                    bfs(i, j)
        
        return no_of_islands
