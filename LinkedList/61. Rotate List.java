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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        ListNode anchor = head;
        for (int i = 0; i < len - k - 1; i++) {
            anchor = anchor.next;
        }
        ListNode res = anchor.next;
        anchor.next = null;
        end.next = head;
        return res;
    }
}

// t:n s:1
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) fast = head;
        }
        if (fast == head) return head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }
}