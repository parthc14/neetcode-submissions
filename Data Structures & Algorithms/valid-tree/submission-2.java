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

        return !isCycle(V, adj);  
    }

    private boolean dfs(int source, List<Integer>[] adj, boolean[] visited, int parent) {
        visited[source] = true;

        for(int nei: adj[source]) {
            if(!visited[nei]) {
                if(dfs(nei, adj, visited, source)){
                    return true;
                }
            } else if(parent != nei) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = dfs(i, adj, visited, -1);
                if (ans) break;
            }
        }
        return ans;
    }
}
