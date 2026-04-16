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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return maxSum;

        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;

        int leftPathSum = dfs(root.left);
        if(leftPathSum < 0) leftPathSum = 0;

        int rightPathSum = dfs(root.right);
        if(rightPathSum < 0) rightPathSum = 0;

        maxSum = Math.max(maxSum, root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
