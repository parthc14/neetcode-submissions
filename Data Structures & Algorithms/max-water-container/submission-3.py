class Solution:
    def maxArea(self, nums: List[int]) -> int:
        max_area = 0

        left, right = 0, len(nums) - 1

        while left < right:
            area = min(nums[left], nums[right]) * (right-left)
            max_area = max(max_area, area)

            if nums[left] < nums[right]:
                left += 1
            else:
                right -= 1
        
        return max_area


"""
          0 1 2 3 4 5 6 7
height = [1,7,2,5,4,7,3,6]
            l r

          area = 2 * 1 = 36
          max = 36


"""