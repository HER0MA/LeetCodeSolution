// solution 1: DFS
// t: node*edges s:edges
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        // represent the graph with ArrayList
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        if(containsCycle(0, -1, graph, visited)) return false;
        return visited.size()==n ? true : false;
    }
    
    private boolean containsCycle(int node, int parent, List<List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        List<Integer> children = graph.get(node);
        for (int child : children) {
            if (child==parent) continue;
            if (visited.contains(child)) return true;
            if (containsCycle(child, node, graph, visited)) return true;
        }
        return false;
    }
}
// Solution 2: Union Find
// t: node*edges s:nodes
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n==1 && edges.length==0) return true;
        // return false if contains isolated piece
        if (n<1 || edges == null || edges.length!=n-1) return false;
        int[] root = new int[n];
        Arrays.fill(root, -1);
        
        for (int[] edge : edges) {
            int root1 = find(edge[0], root);
            int root2 = find(edge[1], root);
            // if two point of an edge have same root
            // the graph contains a cycle
            if (root1==root2) return false;
            root[root2] = root1;
        }
        return true;
    }
    private int find(int node, int[] root) {
        while(root[node]!=-1) {
            node = root[node];
        }
        return node;
    }
}