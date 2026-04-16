"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return node
        clones = {}
        
        def dfs(curr):
            if curr in clones:
                return clones[curr]
            
            copy = Node(curr.val)
            clones[curr] = copy

            for nei in curr.neighbors:
                copy_nei = dfs(nei)
                copy.neighbors.append(copy_nei)
            
            return copy
        

        return dfs(node)

        