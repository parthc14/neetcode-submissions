class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0

        for i in range(len(s)):
            seen = set()
            for j in range(i, len(s)):
                if s[j] not in seen:
                    res = max(res, j - i + 1)
                    seen.add(s[j])
                else:
                    break
                

        return res