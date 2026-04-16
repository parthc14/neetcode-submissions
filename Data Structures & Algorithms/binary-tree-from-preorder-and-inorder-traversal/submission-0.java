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
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        int n = preorder.length;
        for(int i=0; i<n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        // base case
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRootIdx = inorderMap.get(root.val);
        int numsLeft = inRootIdx - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRootIdx-1);

        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRootIdx+1, inEnd); 

        return root;
    }
}
