class Solution:
    def trap(self, heights: List[int]) -> int:
        n = len(heights)
        area = 0
        left_max, right_max = heights[0], heights[-1]
        left, right = 0, n-1

        while left <= right:
            if left_max <= right_max:
                if heights[left] < left_max:
                    area += left_max - heights[left]
                else:
                    left_max = heights[left]
                left += 1
            else:
                if heights[right] < right_max:
                    area += right_max - heights[right]
                else:
                    right_max = heights[right]
                right -=1
        
        

        return area


"""
Input: height = [0,2,0,3,1,0,1,3,2,1]
       left   = [0,2,2,3,3,3,3,3,3,3]                      
       right  = [3,3,3,3,3,3,3,3,2,1]


                 left_max = 3
                 right_max = 3
                 heights[i] = 1

                area = 3-1 = 2 + 2 + 3 + 2 + 

"""
