/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// solution 1: PriorityQueue
// t:nlogk s:k
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val-b.val);
        for (ListNode list : lists) {
            if (list!=null) {
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            p.next = curr;
            if (curr.next!=null) {
                pq.offer(curr.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
// solution 2: merge sort
// t:nlogk s:1
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        return sort(lists, 0, lists.length-1);
    }
    private ListNode sort(ListNode[] lists, int start, int end) {
        if (start==end) return lists[start];
        int mid = start + (end-start)/2;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid+1, end);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1==null ? l2 : l1;
        return dummy.next;
    }
}