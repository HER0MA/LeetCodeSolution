// t:n s:1
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length<2) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int res = prev1;
        for (int i=2; i<nums.length; i++) {
            res = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = res;
        }
        return res;
    }
}