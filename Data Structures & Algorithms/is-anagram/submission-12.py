class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s or not t:
            return False

        if len(s) != len(t):
            return False

        
        char_map = {}

        for ch in s:
            char_map[ch] = char_map.get(ch, 0) + 1
        
        for ch in t:
            if ch in char_map:
                char_map[ch] -= 1
                if char_map[ch] == 0:
                    del char_map[ch]
            else:
                return False



        return len(char_map) == 0
