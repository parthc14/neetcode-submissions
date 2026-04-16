class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        if not s:
            return max_len
        
        n = len(s)

        for i in range(n):
            dups = set()
            for j in range(i, n):
                if s[j] not in dups:
                    dups.add(s[j])
                    max_len = max(max_len, j - i + 1)
                else:
                    break
        return max_len
