class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        if not s:
            return max_len
        
        n = len(s)

        low = 0
        seen = set()
        for high in range(n):
            while s[high] in seen:
                seen.remove(s[low])
                low += 1
            seen.add(s[high])
            max_len = max(max_len, high - low + 1)
        
        return max_len
