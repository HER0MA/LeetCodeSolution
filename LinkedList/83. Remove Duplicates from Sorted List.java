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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}