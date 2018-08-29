// t:2^n s:2^n
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        // sorts makes same number together
        helper(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i=index; i<nums.length; i++) {
            /* After sort, when there are duplicates numbers, 
             * we only care times this number be used, do not care which number we choose
             * so we choose first k numbers if we want to used k of this number,
             * i==index => the previous one are selected
             * nums[i] == nums[i-1] duplicates, do not add nums[i] unless nums[i-1] is added
            */
            if (i==index || nums[i]!=nums[i-1]) {
                curr.add(nums[i]);
                helper(i+1, nums, curr, res);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}