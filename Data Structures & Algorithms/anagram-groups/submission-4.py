class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}

        for s in strs:
            sorted_arr = sorted(s)
            sorted_s = "".join(sorted_arr)

            if sorted_s not in d:
                d[sorted_s] = []
            
            llist = d[sorted_s]
            llist.append(s)
        
        return list(d.values())