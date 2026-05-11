class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if s is None and t is None:
            return True
        
        if s is None or t is None:
            return False
        
        if len(s) != len(t):
            return False
        

        freq_arr = [0] * 26

        for i in range(len(s)):
            freq_arr[ord(s[i]) - ord('a')] += 1

        
        for j in range(len(t)):
            if freq_arr[ord(t[j]) - ord('a')] == 0:
                return False
            freq_arr[ord(t[j]) - ord('a')] -= 1
        
        for i in range(26):
            if freq_arr[i] > 0:
                return False
        
        return True
    