class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9
        m = 9

        def isValid(value, row, col):
            nRow, nCol = (row // 3) * 3, (col // 3) * 3

            for i in range(9):
                if i != row and board[i][col] == value:
                    return False
                if i!= col and board[row][i] == value:
                    return False
                
                r = nRow + (i//3)
                c = nCol + (i % 3)
                if (r != row and c != col) and board[r][c] == value:
                    return False
            
            return True

        n = 9
        m = 9

        for i in range(n):
            for j in range(m):
                if board[i][j] != '.':
                    if not isValid(board[i][j], i, j):
                        return False
        
        return True

