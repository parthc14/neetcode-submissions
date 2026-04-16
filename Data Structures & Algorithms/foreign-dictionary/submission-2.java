class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(String word: words) {
            char[] charArr = word.toCharArray();
            for(char c: charArr) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i=1; i<words.length; i++) {
            String prevWord = words[i-1];
            String currWord = words[i];

            int minLen = Math.min(prevWord.length(), currWord.length());

            if(prevWord.length() > currWord.length() && prevWord.substring(0, minLen).equals(currWord.substring(0, minLen))) {
                return "";
            }

            for(int j = 0; j< minLen; j++) {
                if(prevWord.charAt(j) != currWord.charAt(j)) {
                    if(!adj.get(prevWord.charAt(j)).contains(currWord.charAt(j))) {
                        adj.get(prevWord.charAt(j)).add(currWord.charAt(j));
                        indegree.put(currWord.charAt(j), indegree.get(currWord.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for(Map.Entry<Character, Integer> mpp : indegree.entrySet()) {
            char key = mpp.getKey();
            int value = mpp.getValue();
            if(value == 0) q.offer(key);
        }

        while(!q.isEmpty()) {
            char ch = q.poll();

            res.append(ch);

            for(char nei: adj.get(ch)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.offer(nei);
            }
        }

        if(res.length() != indegree.size()) return "";
        return res.toString();

        
         
    }
}
