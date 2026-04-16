class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True

        V = numCourses
        adj = [[] for _ in range(V)]

        for (v, u) in prerequisites:
            adj[u].append(v)
            

        visited_set, path_set = set(), set()

        def dfs(node):
            path_set.add(node)
            visited_set.add(node)

            for nei in adj[node]:
                if nei in path_set:
                    return True
                if nei not in visited_set:
                    if dfs(nei):
                        return True
                
            path_set.remove(node)
            return False
        
        for node in range(V):
            if node not in visited_set:
                if dfs(node):
                    return False

        return True