class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, word, board, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;   
    }

    private boolean dfs(int row, int col, String word, char[][] board, int startIdx, boolean[][] visited) {
        if(startIdx == word.length()) {
            return true;
        }

        if(row < 0 || col < 0 || row >=board.length || col >= board[0].length || visited[row][col] || word.charAt(startIdx) != board[row][col]) {
            return false;
        }

        visited[row][col] = true;
        
        boolean found =  dfs(row + 1, col, word, board, startIdx+1, visited) || 
                dfs(row -1, col, word, board, startIdx+1, visited) ||
                dfs(row , col + 1, word, board, startIdx+1, visited) ||
                dfs(row, col - 1, word, board, startIdx+1, visited);

        visited[row][col] = false;
        return found;
    }
}
