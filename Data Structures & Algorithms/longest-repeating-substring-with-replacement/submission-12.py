class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        if not s:
            return 0
        n = len(s)
        hash_arr = [0] * 26
        low = 0
        max_freq = 0
        for high in range(n):
            hash_arr[ord(s[high]) - ord('A')] += 1
            max_freq = max(max_freq, hash_arr[ord(s[high]) - ord('A')])
            if high - low  + 1 - max_freq > k:
                hash_arr[ord(s[low]) - ord('A')] -= 1
                low += 1
                
            if high - low  + 1 - max_freq <= k:
                max_len = max(max_len, high - low  + 1)

        return max_len

                



