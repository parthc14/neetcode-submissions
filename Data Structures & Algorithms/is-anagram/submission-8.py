class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        c_map = {}

        for ch in s:
            if ch in c_map:
                c_map[ch] += 1
            else:
                c_map[ch] = 1
        
        for ch in t:
            if ch in c_map:
                c_map[ch] -= 1
                if c_map[ch] == 0:
                    del c_map[ch]
            else:
                return False
        
        return len(c_map) == 0 
