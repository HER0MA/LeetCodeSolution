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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even!=null && even.next!=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}