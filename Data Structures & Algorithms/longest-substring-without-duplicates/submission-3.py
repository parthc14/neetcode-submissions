from collections import defaultdict
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        for i in range(len(s)):
            d = defaultdict(int)
            for j in range(i, len(s)):
                d[s[j]] += 1

                if d[s[j]] > 1 :
                    break
                max_len = max(max_len, j - i +1)
                
        return max_len