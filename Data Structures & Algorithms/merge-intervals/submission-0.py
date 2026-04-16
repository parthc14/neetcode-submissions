class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        if not intervals:
            return res
        
        n = len(intervals)

        if n == 1:
            res.append(intervals[0])
            return res
        

        intervals.sort(key= lambda x: x[0])

        prev_interval = intervals[0]

        for i in range(1, n):
            new_interval = intervals[i]
            
            if new_interval[0] <= prev_interval[1]:
                prev_interval[1] = max(new_interval[1], prev_interval[1])
            
            else:
                res.append(prev_interval)
                prev_interval = new_interval
        
        res.append(prev_interval)
        return res
