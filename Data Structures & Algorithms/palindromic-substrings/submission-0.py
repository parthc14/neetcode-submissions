class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0
        
        if len(s) == 1:
            return 1
        
        n = len(s)
        cnt = 0

        def palindrome(l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -=1
            return True

        for i in range(n):
            for j in range(i, n):
                if palindrome(i, j):
                    cnt += 1
            
        return cnt