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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode temp = head;
        if(temp.next == null) {
            return deleteKthNode(temp, 1);
        }

        int cnt = 0;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }

        temp = head;
        int N = (cnt - n) + 1;
        return deleteKthNode(temp, N);
    }

    public ListNode deleteKthNode(ListNode head, int k) {
        if(k == 1) {
            ListNode temp = head;
            temp = temp.next;
            return temp;
        }
        int cnt = 0;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            cnt++;
            if(cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;

    }
}
