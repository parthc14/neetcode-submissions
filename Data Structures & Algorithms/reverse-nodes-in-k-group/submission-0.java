/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        
        ListNode prevLast = null;
        ListNode newHead = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                }

                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);
            if(temp == head) {
                newHead = kthNode;
            } else {
                prevLast.next = kthNode;   
            }

            prevLast = temp;
            temp = nextNode;
        }
        return newHead;
    }

    private ListNode findKthNode (ListNode node, int k) {
        ListNode temp = node;
        int count = 0;
        while(temp != null) {
            count++;
            if(count == k) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;

        ListNode temp = node;

        while(temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}
