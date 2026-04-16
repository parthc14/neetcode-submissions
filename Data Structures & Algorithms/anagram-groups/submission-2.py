from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)

        for s in strs:
            sorted_s = ''.join(sorted(s))

            d[sorted_s].append(s)

        res = []
        for k,v in d.items():
            res.append(v)
        
        return res

