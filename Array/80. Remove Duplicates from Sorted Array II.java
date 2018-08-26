class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int slow = 2;
        for (int fast=2; fast<nums.length; fast++) {
            if (!(nums[slow-1]==nums[slow-2] && nums[slow-1]==nums[fast])) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}