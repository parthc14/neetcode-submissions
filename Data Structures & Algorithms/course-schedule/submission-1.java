class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        List<Integer>[] adj = new ArrayList[V];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList();
        }

        for(int i=0; i<prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];

            adj[prereq].add(course);
        }

        int[] indegree = new int[V];

        for(int i=0; i<V; i++) {
            for(int neighbor: adj[i]) {
                indegree[neighbor]++;
            }
        }

        return toposort(indegree, adj, V);
    }

    public boolean toposort(int[] indegree, List<Integer>[] adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            count++;

            for(int nei: adj[node]) {
                indegree[nei]--;

                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        return count == V;
        
    }
}
