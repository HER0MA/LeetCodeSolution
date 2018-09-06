// t:2^n s:n
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void helper(int index, int target, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size()==k) {
            if (target==0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i=index; i<=9; i++) {
            if (i>target) break;
            curr.add(i);
            helper(i+1, target-i, k, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}