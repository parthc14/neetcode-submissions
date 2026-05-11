class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        mp = {}
        if not strs:
            return res
            
        for s in strs:
            hashed_s = self.build_hash(s)
            if hashed_s not in mp:
                mp[hashed_s] = []
            mp[hashed_s].append(s)

        for v in mp.values():
            res.append(v)
        
        return res
    

    def build_hash(self, s: str):
        freq_arr = [0] * 26

        for i in range(len(s)):
            freq_arr[ord(s[i]) - ord('a')] += 1
        
        return "#".join(map(str,freq_arr))
        
       