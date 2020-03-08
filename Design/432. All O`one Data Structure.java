class Node {
    int freq;
    Set<String> set;
    Node next;
    Node prev;
    
    Node (int _freq) {
        freq = _freq;
        set = new HashSet<>();
    }
}

class AllOne {
    private Node head;
    private Node tail;
    private Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            if (node.next.freq == node.freq + 1) {
                node.next.set.add(key);
                map.put(key, node.next);
            } else {
                Node next = new Node(node.freq + 1);
                addNode(node, next);
                next.set.add(key);
                map.put(key, next);
            }
            if (node.set.size() == 0) {
                removeNode(node);
            }
        } else {
            if (head.next.freq == 1) {
                head.next.set.add(key);
                map.put(key, head.next);
            } else {
                Node node = new Node(1);
                addNode(head, node);
                node.set.add(key);
                map.put(key, head.next);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node node = map.get(key);
        if (node.freq == 1) {
            node.set.remove(key);
            if (node.set.size() == 0) {
                removeNode(node);
            }
            map.remove(key);
        } else {
            if (node.prev.freq == node.freq - 1) {
                node.set.remove(key);
                node.prev.set.add(key);
                map.put(key, node.prev);
                if (node.set.size() == 0) {
                    removeNode(node);
                }
            } else {
                Node prev = new Node(node.freq - 1);
                prev.set.add(key);
                addNode(node.prev, prev);
                map.put(key, prev);
                node.set.remove(key);
                if (node.set.size() == 0) {
                    removeNode(node);
                }
            }
        }
    }
    
    private void addNode(Node prev, Node node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next = node;
        node.next.prev = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */