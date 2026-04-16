class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        List<Integer>[] adj = new ArrayList[V];
        int[] indegree = new int[V];

        for(int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];

            adj[prereq].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for(int nei: adj[node]) {
                indegree[nei]--;

                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if(res.size() != V) return new int[]{};
        int ansIdx = 0;
        int[] ans = new int[res.size()];

        for(int num: res) {
            ans[ansIdx++] = num;
        }

        return ans;


    }
}
