/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
// t:n s:n
class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node();
        Node p = dummy;
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head == null) head = stack.pop();
            p.next = head;
            head.prev = p;
            if (head.child != null) {
                if (head.next != null) stack.push(head.next);
                head = head.child;
            } else {
                head = head.next;
            }
            p.child = null; // remove child
            p = p.next;
        }
        if (dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }
}