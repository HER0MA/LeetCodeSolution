// t:2^n s:n
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    private void helper(int index, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if(candidates[i]>target) break;
            /* After sort, when there are duplicates numbers, 
             * we only care times this number be used, do not care which number we choose
             * so we choose first k numbers if we want to used k of this number,
             * i==index => the previous one are selected
             * nums[i] == nums[i-1] duplicates, do not add nums[i] unless nums[i-1] is added
            */
            if (i==index || candidates[i]!=candidates[i-1]) {
                curr.add(candidates[i]);
                helper(i+1, candidates, target-candidates[i], curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}