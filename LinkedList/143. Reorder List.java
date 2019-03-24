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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMiddle(head);
        ListNode reversed = reverse(mid.next);
        mid.next = null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head != null || reversed != null) {
            if (head != null) {
                p.next = head;
                head = head.next;
                p = p.next;
            }
            if (reversed != null) {
                p.next = reversed;
                reversed = reversed.next;
                p = p.next;
            }
        }
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}