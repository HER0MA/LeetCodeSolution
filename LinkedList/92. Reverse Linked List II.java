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
        if (head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode startPrev = dummy;
        for (int i = 0; i < m - 1; i++) {
            startPrev = startPrev.next;
        }
        ListNode end = startPrev;
        for (int i = 0; i < n - m + 1; i++) {
            end = end.next;
        }
        ListNode start = startPrev.next;
        ListNode endNext = end.next;
        // unlink the part to be reversed
        startPrev.next = null;
        end.next = null;

        reverse(start);
        // relink
        startPrev.next = end;
        start.next = endNext;
        
        return dummy.next;
    }
    
    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
    }
}