class Solution {
    public int countComponents(int n, int[][] edges) {
        int connectedComponents = 0;

        int V = n;

        List<Integer>[] adj = new ArrayList[V];

        for(int i=0; i<V; i++) {
            adj[i] = new ArrayList();
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]){
                connectedComponents++;
                bfs(i, adj, visited);
            }
        }
        return connectedComponents;
    }

    private void bfs(int i, List<Integer>[] adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[i] = true;
        q.offer(i);

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei: adj[node]) {
                if(!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}
