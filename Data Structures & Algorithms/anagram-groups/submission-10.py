class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        mp = {}
        if not strs:
            return res
            
        for s in strs:
            sorted_s = "".join(sorted(s))
            if sorted_s not in mp:
                mp[sorted_s] = []
            mp[sorted_s].append(s)


        for v in mp.values():
            res.append(v)
        
        return res
        
       