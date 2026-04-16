class Solution {
    public boolean isPalindrome(String s) {
        String strWithSpecialChars = s.replaceAll("[^a-zA-Z0-9]", "");
        String filteredStr = strWithSpecialChars.toLowerCase().trim();
        int start = 0;
        int end = filteredStr.length() - 1;

        while(start < end){
            if(filteredStr.charAt(start) != filteredStr.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
