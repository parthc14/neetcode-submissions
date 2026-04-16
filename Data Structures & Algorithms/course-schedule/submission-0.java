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

        List<Integer> res =  toposort(indegree, adj, V);
        return res.size() == V;
    }

    public List<Integer> toposort(int[] indegree, List<Integer>[] adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            ans.add(node);

            for(int nei: adj[node]) {
                indegree[nei]--;

                if(indegree[nei] == 0) q.offer(nei);
            }
        }

        return ans;
        
    }
}
