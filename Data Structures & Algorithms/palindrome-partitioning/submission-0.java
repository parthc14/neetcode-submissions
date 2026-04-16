class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitionString = new ArrayList<>();
        List<String> currentParitionString = new ArrayList<>();

        palindomePartition(0, s, partitionString, currentParitionString);
        return partitionString;
    }

    private void palindomePartition(int startIdx, String s, List<List<String>> res, List<String> curr) {
        // Todo base cases
        if(startIdx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=startIdx; i<s.length(); i++) {
            if(isPalindrome(s, startIdx, i)) {
                curr.add(s.substring(startIdx, i+1));
                palindomePartition(i+1, s, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIdx, int endIdx) {
        while(startIdx <= endIdx) {
            if(s.charAt(startIdx) != s.charAt(endIdx)) return false;
            startIdx++;
            endIdx--;
        }

        return true;
    }
}
