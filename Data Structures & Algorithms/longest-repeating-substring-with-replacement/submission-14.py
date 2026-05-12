class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        if not s:
            return 0
        n = len(s)
        hash_arr = [0] * 26
        l = 0
        for r in range(n):
            hash_arr[ord(s[r]) - ord('A')] += 1
            while (r - l + 1) - self.find_max_freq(hash_arr) > k:
                hash_arr[ord(s[l]) - ord('A')] -= 1
                l += 1

            max_len = max(max_len, r - l  + 1)

        return max_len

    def find_max_freq(self, hash_arr):
        max_freq = 0
        for i in range(26):
            max_freq = max(max_freq, hash_arr[i])
        return max_freq
                



