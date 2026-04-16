class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        
        def f(open, close, curr):
            if open == close and open + close == 2 * n:
                res.append(curr)
                return
            
            if open < n:
                f(open + 1, close, curr + '(')
            if close < open:
                f(open, close + 1, curr + ')')
        
        
        f(0, 0, "")
        return res

