class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res = []
        if not nums:
            return res

        if len(nums) < k:
            return res


        hash_map = {}

        for num in nums:
            hash_map[num] = hash_map.get(num, 0) + 1
        

        max_heap = []

        for key, val in hash_map.items():
            heapq.heappush(max_heap, (-val, key))
        
        res = []
        while len(res) < k:
            print(len(res))
            res.append(heapq.heappop(max_heap)[1])
        
        return res


