/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// t:n s:1
// Another way is reverse two Linked List
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode high = dummy;
        ListNode low = dummy;
        // head is not null, so low!=null
        while (low.next!=null) {
            low = low.next;
            if (low.val!=9) {
                high = low;
            }
        }
        while (high!=low) {
            high.val = (high.val+1)%10;
            high = high.next;
        }
        high.val = (high.val+1)%10;
        if (dummy.val==0) return dummy.next;
        else return dummy;
    }
}