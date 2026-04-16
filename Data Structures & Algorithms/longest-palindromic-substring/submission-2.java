class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int resLen = -1;
        String res = "";
        for(int i=0; i<s.length(); i++) {
            
            for(int j=i; j < s.length(); j++) {
                int left = i;
                int right = j;

                while(left < right && s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }

                if (left >= right && resLen < (j - i + 1)) {
                    resLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
            
        }

        return res; 
    }
}
