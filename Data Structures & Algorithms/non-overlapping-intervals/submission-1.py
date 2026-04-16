class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        max_non_overlaps = 1
        n = len(intervals)
        intervals.sort(key = lambda x:x[1])

        prev_interval = intervals[0]

        for i in range(1, n):
            curr_interval = intervals[i]

            if curr_interval[0] >= prev_interval[1]:
                max_non_overlaps += 1
                prev_interval = curr_interval
        
        return n - max_non_overlaps
        