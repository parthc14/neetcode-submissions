class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        HashMap<Integer, HashSet<Character>> rowSet = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colSet = new HashMap<>();

        HashMap<String, HashSet<Character>> squares = new HashMap<>();

        for(int row=0; row<9; row++) {
            for(int col = 0; col < 9; col ++){
                if(board[row][col] == '.') continue;
                String squareKey = (row/3) + "," + (col/3);

                if(rowSet.computeIfAbsent(row, k -> new HashSet<>())
                    .contains(board[row][col]) ||
                    colSet.computeIfAbsent(col, k-> new HashSet<>())
                    .contains(board[row][col]) ||
                    squares.computeIfAbsent(squareKey, k-> new HashSet<>())
                    .contains(board[row][col])) {
                        return false;
                    }

                    rowSet.get(row).add(board[row][col]);
                    colSet.get(col).add(board[row][col]);
                    squares.get(squareKey).add(board[row][col]);
            }
            
        }

        return true;
    }
}
