// t:n^min{k,n-k} s:n
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, k, n, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int index, int k, int n, List<Integer> curr, List<List<Integer>> res) {
        if (k==0) {
            res.add(new ArrayList(curr));
            return;
        }
        for (int i=index; i<=n; i++) {
            curr.add(i);
            helper(i+1, k-1, n, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}