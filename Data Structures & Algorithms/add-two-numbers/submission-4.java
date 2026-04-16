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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;
        int sum = 0;

        while(temp1 != null && temp2 != null) {
            sum = (carry + temp1.val + temp2.val);
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp2 != null) {
            sum = (carry + temp2.val);
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            sum = (carry + temp1.val);
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            temp1 = temp1.next;
            
        }

        if(carry != 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }


        return dummy.next;
    }
}
