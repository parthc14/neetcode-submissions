class TrieNode {
    boolean isEndOfWord;
    String endingWord;
    TrieNode[] children;

    TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class Solution {
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0) return res;

        if(words == null || words.length == 0) return res;

        for(String word: words) {
            insertWord(this.root, word);
        }
        
        int n = board.length;
        int m = board[0].length;
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = board[i][j];
                if(this.root.children[ch-'a'] != null) {
                    findTrieWord(this.root, board, i, j, res, directions);
                }
                
            }
        }

        return res;
    }

    private boolean isValid(int row, int col, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m) return false;
        return true;
    }

    private void findTrieWord(TrieNode root, char[][] board, int row, int col, List<String> res, int[][] directions) {
        if(root.isEndOfWord) {
            res.add(root.endingWord);
            root.isEndOfWord = false;
        }

        if(!isValid(row, col, board) || board[row][col] == ' ') {
            return;
        }

        char ch = board[row][col];
        if(root.children[ch-'a'] == null) return;

        board[row][col] = ' ';
        root = root.children[ch-'a'];

        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            findTrieWord(root, board, nRow, nCol, res, directions);

        }
        board[row][col] = ch;

    }

    private void insertWord(TrieNode root, String word) {
        TrieNode curr = this.root;

        for(int i=0; i<word.length(); i++) {
            int letter = word.charAt(i) - 'a';

            if(curr.children[letter] == null) {
                curr.children[letter] = new TrieNode();
            }

            curr = curr.children[letter];
        }
        curr.endingWord = word;
        curr.isEndOfWord = true;
    }

    
    

}
