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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode startPrev = dummy;
        ListNode start = startPrev.next;
        ListNode end = dummy;
        ListNode endNext = end.next;
        while (end != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next;
            }
            // set start and endNext
            start = startPrev.next;
            endNext = end.next;
            // unlink
            startPrev.next = null;
            end.next = null;
            // reverse
            reverse(start);
            // link
            startPrev.next = end;
            start.next = endNext;
            // undate startPrev and end
            startPrev = start;
            end = startPrev;
        }
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