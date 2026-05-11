class Pair:
    def __init__(self, first, second):
        self.first = first
        self.second = second

    def __lt__(self, other):
        if self.first != other.first:
            return self.first < other.first
        return self.second < other.second


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or k is None:
            return []
        mp = {}

        for num in nums:
            if num not in mp:
                mp[num] = 0
            mp[num] += 1
        
        min_heap = []

        for key,v in mp.items():
            heapq.heappush(min_heap, Pair(v, key))
        
        while len(min_heap) > k:
            heapq.heappop(min_heap)

        res = []

        while len(min_heap):
            res.append(heapq.heappop(min_heap).second)
        
        return res