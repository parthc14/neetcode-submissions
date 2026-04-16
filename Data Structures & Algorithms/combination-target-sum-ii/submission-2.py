class Solution:
    def combinationSum2(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def f(idx, curr, target):
            if target == 0:
                res.append(curr[:])
                return

            if target < 0 or idx == len(nums):
                return
            
            

            curr.append(nums[idx])
            f(idx + 1, curr, target - nums[idx])
            curr.pop()

            for i in range(idx+1, len(nums)):
                if nums[i] != nums[idx]:
                    f(i, curr, target)
                    break

           
        nums.sort()
        f(0, [], target)

        return res