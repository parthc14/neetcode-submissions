class Solution:
    def trap(self, heights: List[int]) -> int:
        n = len(heights)
        area = 0
        left_max, right_max = [0] * n, [0] * n

        left_max[0] = heights[0]
        right_max[n-1] = heights[n-1]

        left_max_so_far, right_max_so_far = left_max[0], right_max[n-1]
        for i in range(1, n):
            if heights[i] > left_max_so_far:
                left_max_so_far = heights[i]
            left_max[i] = left_max_so_far

        for i in range(n-2, -1, -1):
            if heights[i] > right_max_so_far:
                right_max_so_far = heights[i]
            right_max[i] = right_max_so_far
        
        for i in range(n):
            if heights[i] != left_max[i] and heights[i] != right_max[i]:
                area += min(left_max[i], right_max[i]) - heights[i]
        

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
