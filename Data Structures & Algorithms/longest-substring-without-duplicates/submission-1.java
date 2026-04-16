class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int n = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < n) {
            char rightChar = s.charAt(right);
            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);

            while(countMap.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                int leftCharCount = countMap.get(leftChar);
                countMap.put(leftChar, leftCharCount - 1);
                if(leftCharCount <= 0) {
                    countMap.put(leftChar, 0);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;    
        }

        return maxLen;
    }
}
