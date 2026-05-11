class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if s is None and t is None:
            return True
        
        if s is None or t is None:
            return False
        
        if len(s) != len(t):
            return False
        

        freq_s = [0] * 26
        freq_t = [0] * 26

        for i in range(len(s)):
            freq_s[ord(s[i]) - ord('a')] += 1
        
        for j in range(len(t)):
            freq_t[ord(t[j]) - ord('a')] += 1
        
        print(freq_t)
        print(freq_t)
        return freq_s == freq_t
    