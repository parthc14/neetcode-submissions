class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return True
        

        def dfs(i):
            if i >= len(nums) - 1:
                return True
            
            max_jump = nums[i]
            if max_jump == 0:
                return False
            
            for j in range(i+1, i + max_jump + 1):
                if dfs(j):
                    return True
            return False
        
        return dfs(0)
