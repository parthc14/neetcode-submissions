class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};


    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if(board[i][m-1] == 'O') {
                dfs(i, m-1, board);
            }
        }

        for(int i=0; i<m; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, board);
            }

            if(board[n-1][i] == 'O') {
                dfs(n-1, i, board);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == ' ') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if(!isValid(row, col, board) || board[row][col] == 'X' || board[row][col] == ' ') {
            return;
        }

        board[row][col] = ' ';

        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            dfs(nRow, nCol, board);
        }

    }

    private boolean isValid(int row, int col, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m) return false;
        return true;
    }
}
