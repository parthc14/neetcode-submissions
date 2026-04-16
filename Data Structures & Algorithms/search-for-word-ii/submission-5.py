class TrieNode:
    def __init__(self):
        self.children = {}
        self.endingWord = ""
        self.isWord = False

    def addWord(self, word):
        curr = self

        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()

            curr = curr.children[c]
        curr.isWord = True
        curr.endingWord = word

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        
        for word in words:
            root.addWord(word)
        
        
        ROWS, COLS = len(board), len(board[0])
        res = []
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]

        def dfs(r, c, node):
            if (r < 0 or c < 0 or r >= ROWS or c >= COLS) or board[r][c] == ' ' or board[r][c] not in node.children:
                return

            node = node.children[board[r][c]]
            if node.isWord:
                res.append(node.endingWord)
                node.isWord = False
            
            ch = board[r][c]
            board[r][c] = ' '
            
            for dir in dirs:
                nR = dir[0] + r
                nC = dir[1] + c

                dfs(nR, nC, node)
            board[r][c] = ch

        for i in range(ROWS):
            for j in range(COLS):
                dfs(i, j, root)
            
        return res





        