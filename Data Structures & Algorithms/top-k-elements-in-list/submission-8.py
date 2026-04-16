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
            
        min_heap = []
        for key, val in hash_map.items():
            heapq.heappush(min_heap, (val, key))

            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        
        while len(min_heap):
            res.append(heapq.heappop(min_heap)[1])

        return res


