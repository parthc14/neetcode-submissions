class Solution:
    def isPalindrome(self, s: str) -> bool:
        if not s:
            return True
        
        start, end = 0, len(s) - 1

        while start < end:
            if s[start].lower().isalnum() and s[end].lower().isalnum():
                if s[start].lower() != s[end].lower():
                    return False
                start += 1
                end -= 1
            
            else:
                if not s[start].lower().isalnum():
                    start += 1
                else:
                    end -= 1
        
        return True
            
        