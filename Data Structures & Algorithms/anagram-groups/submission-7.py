class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}

        for s in strs:
            freq_arr = [0] * 26

            for ch in s:
                freq_arr[ord(ch) - ord('a')] += 1

            if tuple(freq_arr) not in d:
                d[tuple(freq_arr)] = []
            llist = d[tuple(freq_arr)]
            llist.append(s)
        
        return list(d.values())