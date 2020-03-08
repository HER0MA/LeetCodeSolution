class Node {
    int sum;
    Node[] children;
    
    Node () {
        children = new Node[26];
    }
}

class MapSum {
    private Node root = new Node();
    
    // t:n
    public void insert(String key, int val) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.sum = val;
    }
    
    // t:n worst: n^26
    public int sum(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return 0;
            }
            curr = curr.children[ch - 'a'];

        }
        return sumHelper(curr);
    }
    
    private int sumHelper(Node node) {
        if (node == null) return 0;
        int res = node.sum;
        for (int i = 0; i < 26; i++) {
            res += sumHelper(node.children[i]);
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */