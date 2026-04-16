class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        n = len(s)

        l, r = 0, 0

        max_freq = 0
        count_map = [0] * 26

        max_len = 0

        while r < n :
            right_char = ord(s[r])

            count_map[right_char - ord('A')] += 1;
            max_freq = max(max_freq, count_map[right_char - ord('A')])

            while r - l +1 - max_freq > k:
                left_char = ord(s[l])
                count_map[left_char - ord('A')] -= 1;
                max_freq = 0
                for i in range(26):
                    max_freq = max(max_freq, count_map[i])
                l += 1


            if ((r-l + 1) - max_freq) <= k:
                max_len = max(max_len, r - l + 1)
            r += 1
            

        return max_len