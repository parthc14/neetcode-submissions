class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = [ [x, i] for i,x in enumerate(nums)]

        res.sort(key = lambda x: x[0])

        low = 0
        high = len(res) - 1

        while low < high:
            if res[low][0] + res[high][0] == target:
                i, j = res[low][1], res[high][1]
                return [i, j] if i < j else [j, i]
            elif res[low][0] + res[high][0] < target:
                low += 1
            else:
                high -= 1
        
        return [-1, -1]