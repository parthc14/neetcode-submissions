class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        if not strs:
            return res

        anagram_map = {}

        for s in strs:
            original = s
            sorted_s = ""
            count_arr = [0] * 26
            for ch in s:
                count_arr[ord(ch) - ord('a')] += 1
            
            for ch in count_arr:
                sorted_s += str(ch)
                sorted_s += "#"
            
            if sorted_s not in anagram_map:
                anagram_map[sorted_s] = []
            anagram_map[sorted_s].append(original)

        for _, v in anagram_map.items():
            res.append(v)
        
        return res

