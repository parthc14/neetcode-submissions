# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def dfs(p,q):
            if p is None and q is None:
                return True
            if p is None:
                return False
            if q is None:
                return False
            
            res = False
            if p.val == q.val:
                res = self.isSameTree(p, q)
            
            return res or dfs(p.left, q) or dfs(p.right, q)
            
       
        return dfs(root, subRoot)

    def isSameTree(self, p, q):
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        
        if p.val != q.val:
            return False
        
        left = self.isSameTree(p.left, q.left)
        right = self.isSameTree(p.right, q.right)

        return left and right