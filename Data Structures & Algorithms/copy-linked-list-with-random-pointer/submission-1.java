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
        if(head == null) return null;

        insertNodeInBetween(head);
        connectRandomPointers(head);

        return getDeepCopyList(head);
    }

    private void insertNodeInBetween(Node head) {
        Node temp = head;

        while(temp != null) {
            Node copyNode = new Node(temp.val);
            Node nextLink = temp.next;

            temp.next = copyNode;
            copyNode.next = nextLink;
            
            temp = copyNode.next;
        }
    }

    private void connectRandomPointers(Node head) {
        Node temp = head;

        while(temp != null) {
            Node copyNode = temp.next;
            if(temp.random == null) {
                copyNode.random = null;
            } else {
                copyNode.random = temp.random.next;
            }
            temp = copyNode.next;
        }
    }

    private Node getDeepCopyList(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node curr = dummy;

        while(temp != null) {
            curr.next = temp.next;
            temp.next = temp.next.next;
            curr = curr.next;

            temp = temp.next;
        }

        return dummy.next;
    }
}
