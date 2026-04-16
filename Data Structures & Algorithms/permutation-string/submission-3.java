class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) return false;

        int[] s1Map = new int[26];
        int[] windowMap = new int[26];
        for(int i=0; i < n1; i++) {
            s1Map[s1.charAt(i) - 'a']++;
            windowMap[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i=0; i<26; i++) {
            if(s1Map[i] == windowMap[i]) matches++;
        }

        int left = 0;

        for(int right = n1; right < n2; right++) {
            if(matches == 26) return true;

            int rightChar = s2.charAt(right) - 'a';

            windowMap[rightChar]++;
            if(windowMap[rightChar] == s1Map[rightChar]) {
                matches++;
            } else if(windowMap[rightChar] == s1Map[rightChar] + 1) {
                matches --;
            }

            int leftChar = s2.charAt(left) - 'a';
            windowMap[leftChar]--;
            if(windowMap[leftChar] == s1Map[leftChar]) {
                matches++;
            } else if(windowMap[leftChar] == s1Map[leftChar] - 1) {
                matches--;
            }
            left++;
        }

        return matches == 26;
    }
}
