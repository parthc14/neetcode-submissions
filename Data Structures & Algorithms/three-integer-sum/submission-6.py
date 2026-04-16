class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        triplets = set()

        for i in range(len(nums)):
            seen = set()
            for j in range(i+1, len(nums)):
                third = - (nums[i] + nums[j])
                if third in seen:
                    temp = [nums[i], nums[j], third]
                    temp.sort()
                    triplets.add(tuple(temp))
                seen.add(nums[j])
        
        return [ list(triplet) for triplet in triplets]


