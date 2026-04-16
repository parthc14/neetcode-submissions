class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        if not s:
            return max_len
        
        n = len(s)

        low = 0
        hash_map = {}

        for high in range(n):
            if s[high] in hash_map and hash_map[s[high]] >= low:
                low = hash_map[s[high]] + 1
            
            hash_map[s[high]] = high
            max_len = max(max_len, high - low + 1)

        return max_len