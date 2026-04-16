class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return True
        

        farthest_jump = 0

        for idx, val in enumerate(nums):
            if idx > farthest_jump:
                return False
            
            if farthest_jump >= len(nums)-1:
                return True

            farthest_jump = max(farthest_jump, idx + val)

            
        
        return True
