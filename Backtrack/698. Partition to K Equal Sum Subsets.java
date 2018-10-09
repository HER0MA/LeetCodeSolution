// ?t:n*2^n s:n
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%k!=0) return false;
        return helper(0, 0, k, sum/k, new boolean[nums.length], nums);
    }
    private boolean helper(int index, int currSum, int k, int target, boolean[] used, int[] nums) {
        if (k==1) return true;
        // accumulated to sum, search from the first index
        if (currSum == target) return helper(0, 0, k-1, target, used, nums);
        for (int i=index; i<nums.length; i++) {
            if (!used[i] && currSum+nums[i]<=target) {
                used[i] = true;
                // have not accumulated to sum, search from next number
                if (helper(i+1, currSum+nums[i], k, target, used, nums)) return true;
                used[i] = false;
            }
        }
        return false;
    }
}