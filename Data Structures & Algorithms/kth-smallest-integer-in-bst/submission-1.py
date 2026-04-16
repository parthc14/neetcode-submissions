# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        llist = []
        def dfs(root):
            if root is None:
                return
            llist.append(root.val)
            dfs(root.left)
            dfs(root.right)
        
        dfs(root)
        heap = []
        for num in llist:
            heapq.heappush(heap, num)

        res = 0
        
        for i in range(k):
            res = heapq.heappop(heap)
        return res