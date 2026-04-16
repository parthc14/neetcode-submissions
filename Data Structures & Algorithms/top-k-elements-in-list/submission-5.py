from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = defaultdict(int)

        for num in nums:
            d[num] += 1

        arr = []
        for key, v in d.items():
            arr.append([v, key])

        arr.sort(key= lambda x: x[0])

        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        return res
            