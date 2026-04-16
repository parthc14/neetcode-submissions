/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        dfs(root.val, root);
        return goodNodes;
    }

    private void dfs(int maxSoFar, TreeNode root) {
        if(root == null) return;

        if(root.val >= maxSoFar) {
            goodNodes++;
        }
        maxSoFar = Math.max(maxSoFar, root.val);
        
        dfs(maxSoFar, root.left);
        dfs(maxSoFar, root.right);
    }
}
