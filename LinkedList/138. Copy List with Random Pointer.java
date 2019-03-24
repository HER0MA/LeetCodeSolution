/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// t:n s:n
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode res = new RandomListNode(head.label);
        RandomListNode p1 = head;
        RandomListNode p2 = res;
        map.put(p1, p2);
        while (p1.next != null) {
            p2.next = new RandomListNode(p1.next.label);
            p2 = p2.next;
            p1 = p1.next;
            map.put(p1, p2);
        }
        p1 = head;
        p2 = res;
        while (p1 != null) {
            if (p1.random != null) {
                p2.random = map.get(p1.random);
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return res;
    }
}