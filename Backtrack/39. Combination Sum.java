// t:2^n s:n
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int index, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (candidates[i]>target) break;
            curr.add(candidates[i]);
            helper(i, candidates, target-candidates[i], curr, res);
            curr.remove(curr.size()-1);
        }
    }
}