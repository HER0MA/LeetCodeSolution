class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(2, n, new ArrayList<>(), res);
        return res;
    }
    private void helper(int start, int n, List<Integer> curr, List<List<Integer>> res) {
        if (n==1 && curr.size()>1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=start; i<=n; i++) {
            if (n%i==0) {
                curr.add(i);
                helper(i, n/i, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}