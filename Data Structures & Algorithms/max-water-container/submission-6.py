class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_area = 0
        if not heights:
            return max_area
        
        n = len(heights)

        if n < 2:
            return max_area
        area = 0
        low, high = 0, n - 1

        while low < high:
            area = min(heights[low], heights[high]) * (high - low)
            max_area = max(max_area, area)

            if heights[low] < heights[high]:
                low += 1
            else:
                high -= 1
        
        return max_area