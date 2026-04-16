class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        if not s:
            return 0
        n = len(s)
        hash_arr = [0] * 26
        low = 0
        for high in range(n):
            hash_arr[ord(s[high]) - ord('A')] += 1

            while high - low  + 1 - self.find_max_freq(hash_arr) > k:
                hash_arr[ord(s[low]) - ord('A')] -= 1
                low += 1
                
            max_len = max(max_len, high - low  + 1)
        return max_len

    def find_max_freq(self, hash_arr):
        max_freq = 0
        for i in range(26):
            max_freq = max(max_freq, hash_arr[i])
        return max_freq
                



