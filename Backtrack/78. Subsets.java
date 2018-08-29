// t:2^n s:2^n
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        helper(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            helper(i+1, nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}