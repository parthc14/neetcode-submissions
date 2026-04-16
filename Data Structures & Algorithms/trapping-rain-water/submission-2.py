class Solution:
    def trap(self, heights: List[int]) -> int:
        n = len(heights)
        area = 0
        for i in range(n):
            
            left_max, right_max = heights[i], heights[i]
            # left
            for left in range(i-1, -1, -1):
                if heights[left] > left_max:
                    left_max = heights[left]
            # right
            for right in range(i+1, len(heights)):
                if heights[right] > right_max:
                    right_max = heights[right]

            if left_max != heights[i] and right_max != heights[i]:
                area += min(left_max, right_max) - heights[i]
        
        return area


"""
Input: height = [0,2,0,3,1,0,1,3,2,1]
                               i



                 left_max = 3
                 right_max = 3
                 heights[i] = 1

                area = 3-1 = 2 + 2 + 3 + 2 + 

"""
