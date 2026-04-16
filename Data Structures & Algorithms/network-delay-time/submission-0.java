class Solution {
    int maxVal = (int) 1e9;
    public int networkDelayTime(int[][] times, int n, int k) {
        int V = n+1;

        List<List<int[]>> adj = new ArrayList();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++) {
            int[] timesArr = times[i];
            int src = timesArr[0];
            int dest = timesArr[1];
            int time = timesArr[2];
            adj.get(src).add(new int[]{dest, time});
        }

        int[] distanceArr = new int[V];
        Arrays.fill(distanceArr, maxVal);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        distanceArr[k] = 0;
        pq.offer(new int[]{k, 0});


        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int timeTaken = curr[1];

            for(int[] nei: adj.get(node)) {
                int neighbor = nei[0];
                int dist = nei[1];

                if(dist + timeTaken < distanceArr[neighbor]) {
                    distanceArr[neighbor] = dist + timeTaken;
                    pq.offer(new int[]{neighbor, distanceArr[neighbor]});
                }
            }
        }

        int timeTaken = distanceArr[k];

        for(int i=1; i<V; i++) {
            if(distanceArr[i] == maxVal) return -1;

            timeTaken = Math.max(timeTaken, distanceArr[i]);
        }

        return timeTaken;
    }
}
