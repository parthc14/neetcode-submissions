class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s or not t:
            return False

        if len(s) != len(t):
            return False

        
        s_map, t_map = {}, {}

        for ch in s:
            s_map[ch] = s_map.get(ch, 0) + 1
        
        for ch in t:
            cnt = t_map.get(ch, 0) + 1
            t_map[ch] = t_map.get(ch, 0) + 1
        
        return s_map == t_map
