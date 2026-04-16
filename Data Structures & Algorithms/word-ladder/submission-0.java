class Pair {
    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();

        for(String word: wordList) {
            wordSet.add(word);
        }

        if(!wordSet.contains(endWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        wordSet.remove(beginWord);

        while(!q.isEmpty()) {
            Pair wordPair = q.poll();

            String word = wordPair.word;
            int steps = wordPair.level;

            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch<='z'; ch++) {
                    char replacedArr[] = word.toCharArray();
                    replacedArr[i] = ch;
                    String replacedWord = new String(replacedArr);

                    if(wordSet.contains(replacedWord)) {
                        q.offer(new Pair(replacedWord, steps+1));
                        wordSet.remove(replacedWord);
                    }
                }
            }
        }
        
        return 0;
    }
}
