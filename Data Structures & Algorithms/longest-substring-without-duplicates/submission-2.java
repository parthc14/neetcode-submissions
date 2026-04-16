class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int n = s.length();
        Map<Character, Integer> lastIdxMap = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < n) {
            char rightChar = s.charAt(right);
            
            if(lastIdxMap.containsKey(rightChar)) {
                int lastRightCharOccurance = lastIdxMap.get(rightChar);
                int leftChar = s.charAt(left);
                if(lastIdxMap.get(rightChar) >= left) {
                    left = lastRightCharOccurance + 1;
                }
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            lastIdxMap.put(rightChar, right);
            right++;    
        }

        return maxLen;
    }
}
