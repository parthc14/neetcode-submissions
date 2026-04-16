class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;

        for(int i=0; i<n; i++) {
            int[] freqMap = new int[26];
            for(int j=i; j<n; j++) {
                freqMap[s.charAt(j) - 'A']++;
                
                int lenSoFar = (j - i) + 1;
                int mostFreqChar = 0;
                for(int I=0; I<26; I++) {
                    if(freqMap[I] > freqMap[mostFreqChar]) {
                        mostFreqChar = I;
                    }
                }

                int minChanges = lenSoFar - freqMap[mostFreqChar];

                if(minChanges <= k) {
                    maxLen = Math.max(maxLen, lenSoFar);
                }
            }
        }

        return maxLen;
    }
}
