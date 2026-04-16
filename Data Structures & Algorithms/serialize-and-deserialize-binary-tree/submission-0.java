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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(',');
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        int i = 1;
        int n = data.length();
        q.offer(root);
        while(!q.isEmpty() && i < n) {
            TreeNode node = q.poll();
            if(i < n && !parts[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(node.left);
            }
            i++;

            if(i < n && !parts[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }   
}

/**
*       "1,2,3,#,#,4,5,#,#"
        []
*       ["1", "2", "3", "#", "#", "4", "5","#","#"] [1]
*                                  i   
*
*
*/
