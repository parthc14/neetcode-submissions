class Solution:
    def maxArea(self, nums: List[int]) -> int:
        max_area = 0

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                area = min(nums[i], nums[j]) * (j-i)

                max_area = max(max_area, area)
        
        return max_area