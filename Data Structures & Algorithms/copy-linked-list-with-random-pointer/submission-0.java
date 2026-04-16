/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Map<Node, Node> deepCopyMap = new HashMap<>();

        Node temp = head;

        while(temp != null) {
            Node newNode = new Node(temp.val);
            deepCopyMap.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            Node copyNode = deepCopyMap.get(temp);
            copyNode.next = deepCopyMap.get(temp.next);
            copyNode.random = deepCopyMap.get(temp.random);
            temp = temp.next;
        }


        return deepCopyMap.get(head);
        
    }
}
