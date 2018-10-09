// Solution 1: two stack
// s:n
class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    // t:1
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    // t:1
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x>=maxStack.peek()) {
            maxStack.push(x);
        }
    }
    // t:1
    public int pop() {
        int x = stack.pop();
        if (maxStack.peek()==x) {
            maxStack.pop();
        }
        return x;
    }
    // t:1
    public int top() {
        return stack.peek();
    }
    // t:1
    public int peekMax() {
        return maxStack.peek();
    }
    // t:n
    public int popMax() {
        int x = peekMax();
        Stack<Integer> buffer = new Stack<>();
        // use member function to updata stack and maxStack
        while (top()!=x) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return x;
    }
}
// Solution 2: TreeMap and Double LinkedList
// s:n
class MaxStack {
    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList dll;
    // t:1
    public MaxStack() {
        map = new TreeMap();
        dll = new DoubleLinkedList();
    }
    // t:logn
    public void push(int x) {
        Node node = dll.add(x);
        if(!map.containsKey(x))
            map.put(x, new ArrayList<Node>());
        map.get(x).add(node);
    }
	// t:logn
    public int pop() {
        int val = dll.pop();
        List<Node> L = map.get(val);
        L.remove(L.size() - 1);
        if (L.isEmpty()) map.remove(val);
        return val;
    }
    // t:1
    public int top() {
        return dll.peek();
    }
    // t:logn
    public int peekMax() {
        return map.lastKey();
    }
    // t:logn
    public int popMax() {
        int max = peekMax();
        List<Node> L = map.get(max);
        Node node = L.remove(L.size() - 1);
        dll.unlink(node);
        if (L.isEmpty()) map.remove(max);
        return max;
    }
}

class DoubleLinkedList {
    Node head, tail;

    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }

    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

class Node {
    int val;
    Node prev, next;
    public Node(int v) {val = v;}
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */