/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// t:n^2 s:1
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode res = head;
        head = head.next;
        res.next = null;
        while (head != null) {
            ListNode headNext = head.next;
            if (head.val <= res.val) {
                head.next = res;
                res = head;
            } else {
                ListNode p = res;
                while (p.next != null && p.next.val < head.val) {
                    p = p.next;
                }
                head.next = p.next;
                p.next = head;
            }
            head = headNext;
        }
        return res;
    }
}