// t:n s:1
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0;
        int len = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res = Math.max(res, i - start);
                start = i;
            }
        }
        res = Math.max(res, nums.length - start);
        return res;
    }
}