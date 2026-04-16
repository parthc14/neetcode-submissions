class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)

        if not s:
            return 0

        l, r = 0, 0
        last_occurance = [-1] * 128
        max_len = 1
        while r < n:
            right_char = ord(s[r])
            if last_occurance[right_char] >= l:
                idx = last_occurance[right_char]
                l = idx + 1
            
            last_occurance[right_char] = r
            max_len = max(max_len, r - l + 1)
            r+=1

        return max_len