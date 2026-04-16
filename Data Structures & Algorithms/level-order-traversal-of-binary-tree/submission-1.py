# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        if not root:
            return res
        
        q = deque([])
        q.append(root)

        while q:
            levels = []

            size = len(q)

            for i in range(size):
                el = q.popleft()

                levels.append(el.val)

                if el.left:
                    q.append(el.left)
                if el.right:
                    q.append(el.right)
            
            res.append(levels)
        
        return res

