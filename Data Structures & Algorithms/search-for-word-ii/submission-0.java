class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0) return res;

        if(words == null || words.length == 0) return res;

        for(String word: words) {
            if(findWord(board, word)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean findWord(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, word, board, directions)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m) return false;
        return true;
    }

    private boolean dfs(int row, int col, int startIdx, String word, char[][] board, int[][] directions) {
        if(startIdx == word.length()) return true;

        if(!isValid(row, col, board) || word.charAt(startIdx) != board[row][col] || board[row][col] == ' ') {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = ' ';



        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if(dfs(nRow, nCol, startIdx + 1, word, board, directions)) {
                board[row][col] = temp;
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    } 
}
