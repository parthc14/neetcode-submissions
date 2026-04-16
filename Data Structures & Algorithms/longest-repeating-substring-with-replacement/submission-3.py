class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        
        max_freq = 0

        for i in range(len(s)):
            char_count = [0] * 26

            for j in range(i, len(s)):
                char_count[ord(s[j]) - ord('A')] += 1

                max_freq = max(max_freq, char_count[ord(s[j]) - ord('A')])

                changes = (j - i + 1) - max_freq

                if changes <= k:
                    max_len = max(max_len, j-i + 1)
                else:
                    break
        
        return max_len