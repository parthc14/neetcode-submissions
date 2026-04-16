# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.ans = True

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def f(root):
            if root is None:
                return 0
            
            left = f(root.left)
            right = f(root.right)

            if abs(left - right) > 1:
                self.ans = False
            
            return 1 + max(left, right)

        f(root)
        return self.ans