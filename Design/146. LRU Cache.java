class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;
    // t:1
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    // t:1
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.val;
    }
    // t:1
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addFirst(node);
            return;
        }
        Node node = new Node(key, value);
        addFirst(node);
        map.put(key, node);
        if (map.size()>capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
    }
    // t:1
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // t:1
    private void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */