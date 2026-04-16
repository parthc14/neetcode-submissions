class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_area = 0
        if not heights:
            return max_area
        
        n = len(heights)

        if n < 2:
            return max_area
        
        for i in range(n):
            area = 0
            for j in range(i+1, n):
                area = min(heights[i], heights[j]) * (j - i)
                max_area = max(max_area, area)
        
        return max_area