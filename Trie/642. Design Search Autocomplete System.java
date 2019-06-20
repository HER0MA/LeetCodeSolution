class Node {
    Node[] children;
    Map<String, Integer> count;

    Node() {
        children = new Node[27];
        count = new HashMap<>();
    }
}

class AutocompleteSystem {
    private Node root;
    private Node curr;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        curr = root;
        sb = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            curr = root;
            return new ArrayList<String>();
        }
        // append char
        sb.append(c);
        int idx = charToInt(c);
        if (curr.children[idx] == null) {
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
        // select top 3
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? 
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry : curr.count.entrySet()) {
            pq.offer(entry);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (pq.isEmpty()) break;
            res.add(pq.poll().getKey());
        }
        return res;
    }
    
    private void add(String str, int count) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = charToInt(str.charAt(i));
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
            node.count.put(str, node.count.getOrDefault(str , 0) + count);
        }
    }
    
    private int charToInt(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */