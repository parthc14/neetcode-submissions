class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not t or not s:
            return False
        
        n1 = len(s)
        n2 = len(t)

        if n1 != n2:
            return False
        
        s1 = sorted(s)
        t1 = sorted(t)

        return s1 == t1

