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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return mergeSort(0, lists.length-1, lists);
    }

    public ListNode mergeSort(int start, int end, ListNode[] lists) {
        if(start >= end) {
            return lists[start];
        }
        int mid = start + (end-start) / 2;

        ListNode l1 = mergeSort(start, mid, lists);
        ListNode l2 = mergeSort(mid+1, end, lists);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return l1;

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null) {
            temp.next = l1;            
        } else {
            temp.next = l2;            
        }
        return dummy.next;
    }
}
