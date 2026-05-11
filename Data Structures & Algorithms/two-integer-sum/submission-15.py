class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if nums is None:
            return []
        
        new_arr = [ (nums[i], i) for i in range(len(nums))]
        new_arr.sort(key = lambda x: x[0])

        low, high = 0, len(new_arr) - 1

        while low <= high:
            if new_arr[low][0] + new_arr[high][0] == target:
                if new_arr[low][1] > new_arr[high][1]:
                    return [new_arr[high][1], new_arr[low][1]]
                return [new_arr[low][1], new_arr[high][1]]
            elif new_arr[low][0] + new_arr[high][0] > target:
                high -= 1
            else:
                low += 1
        
        return [-1,-1]