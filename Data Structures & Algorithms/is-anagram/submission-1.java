class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m != n) return false;

        int[] sMap = new int[26];

        for(int i=0; i<n; i++) {
            sMap[s.charAt(i) - 'a']++;
        }

        for(int j=0; j<m; j++) {
            int tChar = t.charAt(j) - 'a';
            sMap[tChar]--;
        }

        for(int i=0; i<26; i++) {
            if(sMap[i] != 0) return false;
        }

        return true;
    }
}
