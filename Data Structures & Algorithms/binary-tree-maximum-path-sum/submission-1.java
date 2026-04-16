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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        if(root == null) return res[0];

        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if(root == null) return Integer.MIN_VALUE;

        int leftPathSum = dfs(root.left, res);
        if(leftPathSum < 0) leftPathSum = 0;

        int rightPathSum = dfs(root.right, res);
        if(rightPathSum < 0) rightPathSum = 0;

        res[0] = Math.max(res[0], root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
