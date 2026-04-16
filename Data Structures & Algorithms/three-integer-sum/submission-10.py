class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        if not nums or n <= 2:
            return res

        nums.sort()

        for i in range(n):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            start, end = i + 1, n - 1

            while start < end:
                total = nums[i] + nums[start] + nums[end]

                if total < 0 :
                    start += 1
                elif total > 0:
                    end -= 1
                else:
                    res.append([nums[i], nums[start], nums[end]])
                    start +=1
                    end -=1
                    while start < end and nums[start] == nums[start-1]:
                        start += 1
                    while start < end and nums[end] == nums[end + 1]:
                        end -=1

        return res
                    
                        
            