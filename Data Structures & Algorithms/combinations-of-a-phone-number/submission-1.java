class Solution {
    String[] keyMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        generateCombination(0, digits, "", res);
        return res;
    }

    private void generateCombination(int startIdx, String digits, String current, List<String> res) {
        if(startIdx == digits.length()){
            res.add(current);
            return;
        }

        String s = keyMap[digits.charAt(startIdx) - '0'];
        for(int i=0; i<s.length(); i++) {
            generateCombination(startIdx+1, digits, current + s.charAt(i), res);
        }
    }
}
