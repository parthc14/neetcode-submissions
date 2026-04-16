class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for(int[] e: edges) {
            int u = e[0], v = e[1];
            if(ds.findUPar(e[0]) == ds.findUPar(e[1])) {
                return e;
            }
            ds.unionBySize(u,v);
        }
        return new int[]{};
    }
}

class DisjointSet {
    int[] parent, rank, size;

    DisjointSet(int n) {
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if(parent[node] == node) {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int uParU = findUPar(u);
        int uParV = findUPar(v);

        if(uParU == uParV) return;

        if(size[uParU] < size[uParV]) {
            parent[uParU] = uParV;
            size[uParV] += size[uParU];
        } else {
            parent[uParV] = uParU;
            size[uParU] += size[uParV];
        }
    }

    public void unionByRank (int u, int v) {
        int uParU = findUPar(u);
        int uParV = findUPar(v);

        if(uParU == uParV) return;

        if(rank[uParU] < rank[uParV]) {
            parent[uParU] = uParV;
        } else if(rank[uParV] < rank[uParU]) {
            parent[uParV] = uParU;
        } else {
            parent[uParV] = uParU;
            rank[uParU]++;
        }
    }
}
