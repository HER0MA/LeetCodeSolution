// t:node * edges s:nodes
class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = n;
        // node i has direct superior roots[i]
        // if roots[i]==-1 i do not have superior
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int[] edge : edges) {
            int root1 = find(edge[0], roots);
            int root2 = find(edge[1], roots);
            if (root1!=root2) {
                res --;
                roots[root2] = root1;
            }
        }
        return res;
    }
    // connected nodes will return same value
    private int find(int node, int[] roots) {
        while (roots[node]!=-1) {
            node = roots[node];
        }
        return node;
    }
}
/*
flatten:
roots[i] = i

int find(int node, int[] roots) {
    int i = node;
    while (roots[i]! = i) {
        i = roots[i];
    }
    roots[node] = i;
    return i;
}
*/