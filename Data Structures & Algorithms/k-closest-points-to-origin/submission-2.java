class Distance {
    long distance;
    int[] coordinates;

    Distance(long distance, int[] coordinates) {
        this.distance = distance;
        this.coordinates = coordinates;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> pq = new PriorityQueue<>((a,b) -> Long.compare(a.distance, b.distance));
        
        for(int[] num: points) {
            int row = num[0];
            int col = num[1];

            long dist = calculateDistance(row, col);
            pq.offer(new Distance(dist, new int[]{row, col}));
        }

        int[][] res = new int[k][2];
        int resIdx = 0;
        while(!pq.isEmpty()) {
            Distance dist = pq.poll();
            res[resIdx++] = dist.coordinates;

            if(resIdx == k) return res;
        }
        return res;
    }

    private static long calculateDistance(int x, int y) {
        return (long) x * x + (long) y * y;
    }
}
