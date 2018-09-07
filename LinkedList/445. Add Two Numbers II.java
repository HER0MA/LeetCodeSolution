/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// t:n s:n
// solution 1 : reverse
// solution 2 : stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode p = dummy, p1 = l1, p2 = l2;
        int carry = 0;
        int sum = 0;
        while (p1!=null || p2!=null) {
            sum = carry;
            if (p1!=null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2!=null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum%10);
            p = p.next;
            carry = sum/10;
        }
        if (carry!=0) p.next = new ListNode(carry);
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, nxt = null, curr = head;
        while (curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}