/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        //coner case
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode later = prev;// wrong : later = null
        ListNode first = null;
        ListNode move = null;
        ListNode temp = null;
        while(later!=null){
            later = prev;
            for(int i=0; i<=k && later!=null; i++){
                later = later.next;
                if(i!=k && later==null) return dummy.next;
            }
            first = prev.next;
            move = first.next;
            while(move!=later){
                temp = prev.next;
                prev.next = move;
                first.next = move.next;
                move.next = temp;
                move = first.next; //wrong ans:  move=later
            }
            prev = first;
        }
        return dummy.next;
    }
}