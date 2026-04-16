class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])

        pac, atl = set(), set()

        directions = [[1,0], [-1,0], [0,1], [0,-1]]

        def dfs(r, c, visit, prevHeight):
            visit.add((r,c))
            for dir in directions:
                nr = r + dir[0]
                nc = c + dir[1]

                if 0 <= nr < rows and 0 <= nc < cols and (nr, nc) not in visit and heights[nr][nc] >= prevHeight:
                    dfs(nr, nc, visit, heights[nr][nc])
            
    
        for r in range(rows):
            dfs(r, 0, pac, heights[r][0])
            dfs(r, cols-1, atl, heights[r][cols-1])
        
        for c in range(cols):
            dfs(0, c, pac, heights[0][c])
            dfs(rows-1, c, atl, heights[rows-1][c])
        res = []

        for r in range(rows):
            for c in range(cols):

                if (r,c) in pac and (r,c) in atl:
                    res.append([r,c])
        return res