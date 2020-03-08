// t:V+E s:n
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, graph, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int idx, int[][] graph, List<Integer> list, List<List<Integer>> res) {
        list.add(idx);
        if (idx == graph.length - 1) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 0; i < graph[idx].length; i++) {
            helper(graph[idx][i], graph, list, res);
        }
        list.remove(list.size() - 1);
    }
}