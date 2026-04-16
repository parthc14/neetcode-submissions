"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0
        
        n = len(intervals)

        if n == 1:
            return 1

        intervals.sort(key = lambda interval: interval.start)

        meeting_rooms = 1
        min_heap = []

        heapq.heappush(min_heap, intervals[0].end)

        for i in range(1, n):
            curr_interval = intervals[i]

            if curr_interval.start < min_heap[0]:
                meeting_rooms += 1

            else:
                heapq.heappop(min_heap)
            heapq.heappush(min_heap, curr_interval.end)

        return meeting_rooms

       

        