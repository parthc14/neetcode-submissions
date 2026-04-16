class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int sIdx = -1;
        int minLength = Integer.MAX_VALUE;

        int[] tMap = new int[256];
        for(char ch: t.toCharArray()) {
            tMap[ch]++;
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < n1) {
            int rightChar = s.charAt(right);
            if(tMap[rightChar] > 0) {
                count++;
            }
            tMap[rightChar]--;

            while(count == n2) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    sIdx = left;
                }

                int leftChar = s.charAt(left);
                tMap[leftChar]++;
                if(tMap[leftChar] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLength);

    }
}
