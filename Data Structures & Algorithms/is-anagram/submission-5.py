from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        d = defaultdict(int)
        

        for ch in s:
            d[ch] += 1
        
        for ch in t:
            d[ch] -= 1
        

        for k, v in d.items():
            if v < 0 or v > 0:
                return False
        
        return True


        
"""

Input: s = "racecar", t = "carrace"


"""