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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode sp = smallHead;
        ListNode bp = bigHead;
        while (head != null) {
            if (head.val < x) {
                sp.next = head;
                sp = sp.next;
            } else {
                bp.next = head;
                bp = bp.next;
            }
            head = head.next;
        }
        bp.next = null; // if not, memory exceed
        sp.next = bigHead.next;
        return smallHead.next;
    }
}
// t:n s:1
// move smaller one after prevAnchor 
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevAnchor = dummy;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (prevAnchor == prev) {
                    prevAnchor = prevAnchor.next;
                    prev = prev.next;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = prevAnchor.next;
                    prevAnchor.next = curr;
                    prevAnchor = prevAnchor.next;
                    curr = prev.next;
                }
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}