class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int n = s.length();

        for(int i=0; i<n; i++) {
            Map<Character, Integer> countMap = new HashMap<>();

            for(int j=i; j<n; j++) {
                if(!countMap.containsKey(s.charAt(j))) {
                    countMap.put(s.charAt(j), 1);
                    maxLen = Math.max(maxLen, j - i + 1);
                } else break;
            }
        }

        return maxLen;
    }
}
