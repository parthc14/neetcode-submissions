class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;

        for(int i=0; i<word.length(); i++) {
            int ch = word.charAt(i) - 'a';

            if(curr.children[ch] == null) {
                curr.children[ch] = new TrieNode();
            }

            curr = curr.children[ch];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return isSearchUtil(word, this.root, 0);
    }

    private boolean isSearchUtil(String word, TrieNode root, int idx) {
        TrieNode curr = root;
        for(int i=idx; i<word.length(); i++) {
            char ch = word.charAt(i);

            if(ch == '.') {
                for(TrieNode child : curr.children) {
                    if(child != null ) {
                        if(isSearchUtil(word, child, i + 1)) {
                            return true;
                        }
                    }
                }

                return false;
            } else {
                int letter = ch - 'a';
                if(curr.children[letter] == null) return false;
                curr = curr.children[letter];
            }
        }

        if(curr != null) {
            return curr.isEndOfWord;
        }

        return false;
    }
}
