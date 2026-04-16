class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        int[] freqMap = new int[26];
        
        int left = 0;
        int right = 0;

        while(right < n) {
            int rightChar = s.charAt(right) - 'A';
            freqMap[rightChar]++;

            int mostFreqCharFrequency = findMostFreq(freqMap);
            
            while((right - left) + 1 - freqMap[mostFreqCharFrequency] > k) {
                int leftChar = s.charAt(left) - 'A';
                freqMap[leftChar]--;
                mostFreqCharFrequency = findMostFreq(freqMap);
                left++;
            }

            int currentLen = (right - left) + 1;

            if(currentLen - freqMap[mostFreqCharFrequency] <= k) {
                maxLen = Math.max(maxLen, currentLen);
            }            
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
