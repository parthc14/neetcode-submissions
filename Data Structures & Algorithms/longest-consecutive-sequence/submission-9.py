class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0

        if not nums:
            return res

        def find_next(no):
            for num in nums:
                if num == no:
                    return True
            return False


        for num in nums:
            local_max = 1
            next_no = num + 1
            while find_next(next_no):
                next_no += 1
                local_max += 1

            res = max(res, local_max)

        return res