class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        n = len(s)

        if n == 1:
            return s[0]

        res = ""
        
        def palindrome(start, end):
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True


        for i in range(n):
            for j in range(i, n):
                if palindrome(i, j):
                    if j - i + 1 > len(res):
                        res = s[i:j+1]
        
        return res
