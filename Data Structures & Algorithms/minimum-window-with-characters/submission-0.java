class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int sIdx = -1;
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<n1; i++) {

            int[] tMap = new int[256];
            for(char ch: t.toCharArray()) {
                tMap[ch]++;
            }

            int count = 0;
            for(int j=i; j<n1; j++) {
                if(tMap[s.charAt(j)] > 0) {
                    count++;
                    tMap[s.charAt(j)]--; 
                }

                if(count == n2) {
                    if (j - i + 1 < minLength) {
                        sIdx = i;
                        minLength = j - i + 1;
                    }
                    break;
                }
            }
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLength);

    }
}
