class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0
        
        if len(s) == 1:
            return 1
        
        n = len(s)
        cnt = 0

        def helper(l, r):
            nonlocal cnt

            while l >=0 and r < n and s[l] == s[r]:
                cnt += 1
                l -= 1
                r += 1

        for i in range(n):
            helper(i, i)
            helper(i, i+1)
            
        return cnt