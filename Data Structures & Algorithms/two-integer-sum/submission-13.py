class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if nums is None:
            return []
        
        mp = {}
        res = []
        
        for i in range(len(nums)):
            if target - nums[i] in mp:
                return [mp[target - nums[i]], i]

            mp[nums[i]] = i
        return [-1,-1]