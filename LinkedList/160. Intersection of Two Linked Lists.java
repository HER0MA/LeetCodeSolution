/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// t:n s:1
// Solution 1: length
// Solution 2: form cycle and find entrance
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        while (lenA>lenB) {
            headA = headA.next;
            lenA --;
        }
        while (lenB>lenA) {
            headB = headB.next;
            lenB --;
        }
        // if no intersection
        // loop ends in headA==headB==null
        while (headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int len(ListNode head) {
        int res = 0;
        while (head!=null) {
            head = head.next;
            res ++;
        }
        return res;
    }
}