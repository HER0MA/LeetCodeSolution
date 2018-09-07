/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// t:n s:n
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = null, nxt = null;
        while (prev.next!=null && prev.next.next!=null) {
            curr = prev.next;
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = curr;
            prev.next = nxt;
            prev = curr;
        }
        return dummy.next;
    }
}