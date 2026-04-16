class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if n - 1 < len(edges):
            return False
        
        V = n
        adj = [[] for _ in range(V)]

        for (u,v) in edges:
            adj[v].append(u)
            adj[u].append(v)

        visited = set()

        def dfs(node, parent):
            visited.add(node)

            for nei in adj[node]:
                if nei not in visited:
                    if dfs(nei, node):
                        return True

                elif nei != parent:
                    return True
        
            return False

    
        if dfs(0, -1):
            return False

        if len(visited) != n:
            return False
        
        return True


        