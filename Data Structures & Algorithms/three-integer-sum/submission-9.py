class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        if not nums or n <= 2:
            return res

        triplet_set = set() 

        for i in range(n):
            local_set = set()
            for j in range(i+1, n):
                third = -(nums[i] + nums[j])
                if third in local_set:
                    temp = sorted([nums[i], nums[j], third])
                    triplet_set.add(tuple(temp))
                local_set.add(nums[j])
        return list(triplet_set)