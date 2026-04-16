class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        n = len(s)

        if n == 1:
            return s[0]

        res = ""
        
        def helper(l, r):
            nonlocal res
            while l>=0 and r < n and s[l] == s[r]:
                if r - l + 1 > len(res):
                    res = s[l:r+1]
                l -=1
                r +=1
            

        for i in range(n):
            helper(i, i)

            helper(i, i+1)
        
        return res
