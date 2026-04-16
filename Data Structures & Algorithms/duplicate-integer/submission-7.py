class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        d = {}

        for num in nums:
            if d.get(num, 0) == 0:
                d[num] = 1
            else:
                return True
        return False
                