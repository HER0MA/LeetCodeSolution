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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next!=null && prev.next.next!=null) {
            if (prev.next.val == prev.next.next.val) {
                ListNode p = prev.next.next;
                while (p!=null && p.val==prev.next.val) {
                    p = p.next;
                }
                prev.next = p;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}