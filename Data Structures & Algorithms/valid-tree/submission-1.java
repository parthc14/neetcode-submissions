class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int V = n;
        if (edges.length != V - 1) return false;

        List<Integer>[] adj = new ArrayList[V];
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList();
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        return isCycle(V, adj) ? false : true;  
    }

    private boolean bfs(int i, List<Integer> adj[], boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, -1});
        
        visited[i] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];
            
            for (int it : adj[node]) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(new int[]{it, node});
                } 

                else if (it != parent) return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = bfs(i, adj, visited);
                
                if (ans) break;
            }
        }
        return ans;
    }
}
