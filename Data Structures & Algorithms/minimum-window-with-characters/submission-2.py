class Solution:
    def minWindow(self, s: str, t: str) -> str:
        sIdx = -1
        min_len = float('inf')
        n2 = len(t)
        
        for i in range(len(s)):
            tMap = [0] * 256

            cnt = 0
            for ch in t:
                tMap[ord(ch)] += 1

            for j in range(i, len(s)):
                if tMap[ord(s[j])] > 0:
                    cnt += 1
                tMap[ord(s[j])] -= 1
            
                if cnt == len(t):
                    if j - i + 1 < min_len:
                        sIdx = i
                        min_len = j - i + 1
                    break
        return "" if sIdx == -1 else s[sIdx: sIdx + min_len] 
