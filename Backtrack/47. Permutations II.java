// t:n! s:n
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size()==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            /* only use first k number when k same numbers appear
             * if used -> do not used it again
             * nums[i]==nums[i-1] && !used[i-1] -> previous same number is not used, 
             * we do not use this one
             * !! i!=0 is necessary
            */
            if (used[i] || i!=0 && nums[i]==nums[i-1] && !used[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            used[i] = true;
            helper(nums, used, curr, res);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}