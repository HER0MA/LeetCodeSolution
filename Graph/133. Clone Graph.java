/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
// t:V+E s:V
// DFS
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node currCopy = new Node(node.val, new ArrayList<>());
        map.put(node, currCopy);
        for (Node next : node.neighbors) {
            Node nextCopy = dfs(next, map);
            currCopy.neighbors.add(nextCopy);
        }
        return currCopy;
    }
}
// BFS
class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(node.val, new ArrayList<>());
        queue.offer(node);
        map.put(node, res);
        while (!queue.isEmpty()) {
            // current node has a copy
            Node curr = queue.poll();
            Node currCopy = map.get(curr);
            for (Node next : curr.neighbors) {
                if (map.containsKey(next)) {
                    currCopy.neighbors.add(map.get(next));
                } else {
                    // copy here, beacaue we need set edges
                    Node nextCopy = new Node(next.val, new ArrayList<>());
                    map.put(next, nextCopy);
                    currCopy.neighbors.add(nextCopy);
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}