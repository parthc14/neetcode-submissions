class TrieNode {

    boolean isWordEnd;
    TrieNode[] children;

    public TrieNode() {
        isWordEnd = false;
        children = new TrieNode[26];
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++) {
            int letter = word.charAt(i) - 'a';

            if(curr.children[letter] == null) {
                return false;
            }
            curr = curr.children[letter]; 
        }

        if(curr != null) {
            return curr.isWordEnd;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i=0; i<prefix.length(); i++) {
            int letter = prefix.charAt(i) - 'a';

            if(curr.children[letter] == null) return false;
            curr = curr.children[letter];
        }

        return true;
    }
}
