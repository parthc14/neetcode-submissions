class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = [[ 0 for _ in range(2)] for _ in range(len(nums))]

        for i,n in enumerate(nums):
            arr[i][0] = n
            arr[i][1] = i
        
        arr.sort(key= lambda x: x[0])

        start = 0
        end = len(nums) - 1

        while start < end:
            if arr[start][0] + arr[end][0] < target:
                start +=1
            elif arr[start][0] + arr[end][0] > target:
                end -=1
            else:
                temp = sorted([arr[start][1], arr[end][1]])
                return temp
                
        
        return [-1, -1]