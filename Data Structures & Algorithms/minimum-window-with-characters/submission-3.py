class Solution:
    def minWindow(self, s: str, t: str) -> str:
        sIdx = -1
        min_len = float('inf')
        n2 = len(t)
        cnt = 0
        tMap = [0] * 256

        for ch in t:
            tMap[ord(ch)] += 1

        left = 0
        for right in range(len(s)):
            if tMap[ord(s[right])] > 0:
                cnt += 1
            tMap[ord(s[right])] -= 1

            while cnt == n2:
                if right - left + 1 < min_len:
                    sIdx = left
                    min_len = right - left +1
            
                tMap[ord(s[left])] += 1

                if tMap[ord(s[left])] > 0:
                    cnt -= 1
                left += 1
        return "" if sIdx == -1 else s[sIdx: sIdx + min_len]
        
