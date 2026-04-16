class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True

        V = numCourses
        indegree = [0 for _ in range(V)]
        adj = [[] for _ in range(V)]

        for (v, u) in prerequisites:
            adj[u].append(v)
            indegree[v] += 1

        queue = deque([])
        for i in range(V):
            if indegree[i] == 0:
                queue.append(i)

        cnt = 0
        while queue:
            node = queue.popleft()
            cnt += 1
            for nei in adj[node]:
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    queue.append(nei)
        
        return cnt == numCourses

