class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        if not nums or n <= 2:
            return res

        triplet_set = set() 
        

        for i in range(n):

            for j in range(i+1, n):

                for k in range(j+1, n):
                    if nums[i] + nums[j] + nums[k] == 0:
                        temp_arr = sorted([nums[i], nums[j], nums[k]])
                        triplet_set.add(tuple(temp_arr))
        
        return list(triplet_set)