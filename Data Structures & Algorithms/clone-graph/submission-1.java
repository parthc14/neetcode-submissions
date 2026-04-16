/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> copyMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        copyMap.put(node, new Node(node.val));
        q.offer(node);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();

            for(Node nb: curr.neighbors) {
                if(!copyMap.containsKey(nb)){
                    copyMap.put(nb, new Node(nb.val));
                    q.offer(nb);
                }
                copyMap.get(curr).neighbors.add(copyMap.get(nb));
            }
        }

        return copyMap.get(node);
    }
}