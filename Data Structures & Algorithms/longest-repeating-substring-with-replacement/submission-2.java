class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        int[] freqMap = new int[26];
        
        int left = 0;
        int right = 0;

        int maxFreq = 0;

        while(right < n) {
            int rightChar = s.charAt(right) - 'A';
            freqMap[rightChar]++;
            maxFreq = Math.max(maxFreq, freqMap[rightChar]);
            
            
            if((right - left) + 1 - maxFreq > k) {
                int leftChar = s.charAt(left) - 'A';
                freqMap[leftChar]--;
                left++;
            }

            int currentLen = (right - left) + 1;
            maxLen = Math.max(maxLen, currentLen);     
            right++;
        }

        return maxLen;
    }

    private int findMostFreq(int[] freqMap) {
        int mostFreqChar = 0;

        for(int i=0; i<26; i++) {
            if(freqMap[i] > freqMap[mostFreqChar]) {
                mostFreqChar = i;
            }
        }
        return mostFreqChar;
    }
}
