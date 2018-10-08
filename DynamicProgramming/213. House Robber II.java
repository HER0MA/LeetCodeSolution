// t:n s:1
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    private int rob(int[] nums, int start, int end) {
        if (start==end) return nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);
        int prev2 = nums[start];
        int res = prev1;
        for (int i=start+2; i<=end; i++) {
            res = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = res;
        }
        return res;
    }
}