// t:n s:1
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int state = nums[0];
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            state = Math.max(state, 0) + nums[i];
            res = Math.max(state, res);
        }
        return res;
    }
}