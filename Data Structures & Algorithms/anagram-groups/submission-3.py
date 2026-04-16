from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)

        for s in strs:
            count = [0]*26
            for ch in s:
                count[ord(ch)-ord('a')] += 1
            key = tuple(count)
            d[key].append(s)
           
        res = []
        for k,v in d.items():
            res.append(v)
        
        return res

