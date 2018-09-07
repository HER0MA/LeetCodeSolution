/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// t:n s:1
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i=1; i<m; i++) {
            prev = prev.next;
        }
        ListNode mPrev = prev;
        ListNode curr = prev.next;
        ListNode nxt = null;
        for (int i=0; i<n-m; i++) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        nxt = curr.next;
        curr.next = prev;
        mPrev.next.next = nxt;
        mPrev.next = curr;
        return dummy.next;
    }
}