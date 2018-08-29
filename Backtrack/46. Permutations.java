// t:n*n! s:1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        helper(nums, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size()==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!curr.contains(nums[i])) { // O(n)
                curr.add(nums[i]);
                helper(nums, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}