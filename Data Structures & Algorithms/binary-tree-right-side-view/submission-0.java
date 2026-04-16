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
class TreeState {
    int row;
    TreeNode node;

    TreeState(int row, TreeNode node) {
        this.row = row;
        this.node = node;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeState> q = new LinkedList<>();
        HashMap<Integer, TreeNode> rowMap = new HashMap<>();

        q.offer(new TreeState(0, root));

        while(!q.isEmpty()) {
            TreeState nodeState = q.poll();
            int row = nodeState.row;
            TreeNode node = nodeState.node;

            rowMap.put(row, node);

            if(node.left != null) {
                q.offer(new TreeState(row + 1, node.left));
            }

            if(node.right != null) {
                q.offer(new TreeState(row + 1, node.right));
            }            
        }

        

        for(Map.Entry<Integer, TreeNode> entry: rowMap.entrySet()) {
            int rowNo = entry.getKey();
            TreeNode node = entry.getValue();

            result.add(node.val);
        }

        return result;
    }
}
