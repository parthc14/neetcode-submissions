class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS, COLS = len(board), len(board[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
        def isValid(r, c):
            if 0 <= r < ROWS and 0 <= c < COLS:
                return True
            return False

        def dfs(row, col):
            board[row][col] = '#'

            for dir in dirs:
                nR = row + dir[0]
                nC = col + dir[1]

                if isValid(nR, nC) and board[nR][nC] == 'O':
                    dfs(nR, nC)


        for r in range(ROWS):
            if board[r][0] == 'O':
                dfs(r, 0)
            if board[r][COLS-1] == 'O':
                dfs(r, COLS-1)
        
        for c in range(COLS):
            if board[0][c] == "O":
                dfs(0, c)
            
            if board[ROWS-1][c] == 'O':
                dfs(ROWS-1, c)
        
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == '#':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'
        

                