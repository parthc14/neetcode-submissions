class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals and not newInterval:
            return False
        
        if not intervals:
            return [newInterval]

        inserted = False
        res = []

        for interval in intervals:
            if not inserted and interval[0] >= newInterval[0]:
                res.append(newInterval)
            
            res.append(interval)
        
        if not inserted:
            res.append(newInterval)
        
        return self.merge(res)
        



    
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        
        
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