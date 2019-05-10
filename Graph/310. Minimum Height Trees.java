// t:E+V s:E+V
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int leafParent : list.get(leaf)) {
                    list.get(leafParent).remove(leaf);
                    if (list.get(leafParent).size() == 1) {
                        newLeaves.add(leafParent);
                    }
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}