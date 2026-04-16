class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();

        generate(0, 0, n, curr, res);
        return res;
    }

    private void generate(int open, int close, int n, StringBuilder curr, List<String> res) {
        if(open == close && open + close == 2*n) {
            res.add(curr.toString());
            return;
        }

        if(open < n) {
            curr.append('(');
            generate(open + 1, close, n, curr, res);
            curr.deleteCharAt(curr.length()-1);

        }
    
        if(close < open) {
            curr.append(')');
            generate(open, close + 1, n, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
