"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if not intervals:
            return True
        
        n = len(intervals)

        if n == 1:
            return True
        

        intervals.sort(key = lambda x: x.start)
        prev_int = intervals[0]

        for i in range(1, n):
            curr_int = intervals[i]
            if curr_int.start < prev_int.end:
                return False
            
            prev_int.start = curr_int.start
            prev_int.end = curr_int.end
        
        return True
