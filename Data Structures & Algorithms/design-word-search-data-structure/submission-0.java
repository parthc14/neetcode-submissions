class TrieNode {

    boolean isWordEnd;
    TrieNode[] children;

    public TrieNode() {
        isWordEnd = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++) {
            int letter = word.charAt(i) - 'a';
            if(curr.children[letter] == null) {
                curr.children[letter] = new TrieNode();
            }
            curr = curr.children[letter];
        }

        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs (String word, int j, TrieNode root) {
        TrieNode curr = root;

        for(int i=j; i<word.length(); i++) {
            char c = word.charAt(i);

            if(c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
               int letter = c - 'a';
               if(curr.children[letter] == null) return false;
               curr = curr.children[letter];
            }
        }
        
        return curr.isWordEnd;
    }
}
