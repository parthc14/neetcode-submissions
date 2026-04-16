class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int letter = ch - 'a';
            if(curr.children[letter] == null) return false;
            curr = curr.children[letter];
        }

        if(curr != null) {
            return curr.isEndOfWord;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int letter = ch - 'a';
            if(curr.children[letter] == null) return false;
            curr = curr.children[letter];
        }

        return true;
    }
}
