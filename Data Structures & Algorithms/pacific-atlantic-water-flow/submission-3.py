class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        res = []
        if not heights:
            return res
        
        rows = len(heights)
        cols = len(heights[0])
        directions = [[1,0], [-1,0], [0,1], [0,-1]]

        def isValid(row, col):
            return 0 <= row < rows and 0 <= col < cols

        def can_reach_both(row, col):
            visited = set()

            pacific = False
            atlantic = False

            def dfs(r, c):
                nonlocal pacific
                nonlocal atlantic

                if (r,c) in visited:
                    return False
                
                visited.add((r, c))

                if r == 0 or c == 0:
                    pacific = True

                if r == rows - 1 or c == cols - 1:
                    atlantic = True

                if pacific and atlantic:
                    return True
                
                for dir in directions:
                    nRow = r + dir[0]
                    nCol = c + dir[1]

                    if not isValid(nRow, nCol):
                        continue
                    
                    if heights[nRow][nCol] <= heights[r][c]:
                        if dfs(nRow, nCol):
                            return True

                return False

            return dfs(row, col)

        for r in range(rows):
            for c in range(cols):
                if can_reach_both(r, c):
                    res.append([r, c])
        return res