class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)

        if not s:
            return 0

        l, r = 0, 0
        count_arr = [0] * 128
        max_len = 1
        while r < n:
            right_char = ord(s[r])
            count_arr[right_char] += 1
            
            while count_arr[right_char] > 1:
                left_char = ord(s[l])

                count_arr[left_char] -= 1
                l+=1

            max_len = max(max_len, r - l + 1)
            r+=1

        return max_len