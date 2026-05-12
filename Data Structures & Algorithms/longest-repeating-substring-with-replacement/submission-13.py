class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        if not s:
            return 0
        n = len(s)
        for i in range(n):

            hash_arr = [0] * 26

            for j in range(i, n):
                hash_arr[ord(s[j]) - ord('A')] += 1
                if (j - i  + 1) - self.find_max_freq(hash_arr) <= k:
                    max_len = max(max_len, j - i  + 1)
                else:
                    break
        return max_len

    def find_max_freq(self, hash_arr):
        max_freq = 0
        for i in range(26):
            max_freq = max(max_freq, hash_arr[i])
        return max_freq
                



