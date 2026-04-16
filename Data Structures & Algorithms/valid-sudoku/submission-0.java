class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int row=0; row<9; row++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            } 
        }

        for(int col=0; col<9; col++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            } 
        }

        for(int square=0; square<9; square++) {
            int row = (square/3) * 3;
            int col = (square%3) * 3;
            HashSet<Character> seen = new HashSet<>();

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int nRow = row + i;
                    int nCol = col + j;

                    if(board[nRow][nCol] == '.') continue;
                    if(seen.contains(board[nRow][nCol])) return false;
                    seen.add(board[nRow][nCol]);
                }
            } 
        }

        return true;

        


    }
}
