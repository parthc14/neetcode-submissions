class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for(int i=0; i<n; i++) {
            board.add(".".repeat(n));
        }

        solve(0, board, res);
        return res;
    }

    private void solve(int col, List<String> board, List<List<String>> res) {
        if(col == board.size()) {
            res.add(new ArrayList(board));
            return;
        }

        for(int row = 0; row < board.size(); row++){
            if(isSafe(board, row, col)) {
                char[] colArr = board.get(row).toCharArray();
                colArr[col] = 'Q';
                board.set(row, new String(colArr));
                
                solve(col+1, board, res);

                colArr[col] = '.';
                board.set(row, new String(colArr));
            }
        }
    }

    private boolean isSafe(List<String> board, int row, int col) {
        int r = row, c = col;

        while(r >= 0 && c >= 0) {
            if(board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row ;
        c = col;
        while(c >= 0) {
            if(board.get(r).charAt(c) == 'Q') return false;
            c--;
        }
        r = row;
        c = col;
        while(r < board.size() && c >=0) {
            if(board.get(r).charAt(c) == 'Q') return false;
            r++;
            c--;
        }
        return true;
    }
}
