from collections import defaultdict
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = defaultdict(int)

        for i, n in enumerate(nums):
            if target - n in d:
                return [d[target - n], i]
            d[n] = i
        return [-1,-1]