/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointerPrev = dummy;
        ListNode pointer = head;
        ListNode mPointer=null, mPrev=null, nPointer=null;
        int i=1;
        while(pointer!=null && i<=n){
            if(i==m){
                mPointer = pointer;
                mPrev = pointerPrev;
            }
            if(i==n){
                nPointer = pointer;
            }
            pointerPrev = pointer;
            pointer = pointer.next;
            i++;
        }
        ListNode dummyNew = new ListNode(0);
        ListNode pointerTemp = mPointer;
        ListNode pointerTempNext = pointerTemp.next;
        while(pointerTemp!=nPointer){
            pointerTemp.next = dummyNew.next;
            dummyNew.next = pointerTemp;
            pointerTemp = pointerTempNext;
            pointerTempNext = pointerTemp.next;
        }
        pointerTemp.next = dummyNew.next;
        dummyNew.next = pointerTemp;
        mPrev.next = dummyNew.next;
        mPointer.next = pointerTempNext;
        return dummy.next;
    }
}