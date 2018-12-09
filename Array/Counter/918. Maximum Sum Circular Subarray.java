// t:n s:1
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // regard nums as normal array and caculate max subarray and min subarray
        // if the max array take both head and tail, the remaining part is min subarray
        int currMax = nums[0];
        int totalMax = nums[0];
        int currMin = nums[0];
        int totalMin = nums[0];
        int sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            currMax = Math.max(currMax, 0) + nums[i];
            totalMax = Math.max(totalMax, currMax);
            currMin = Math.min(currMin, 0) + nums[i];
            totalMin = Math.min(totalMin, currMin);
            sum += nums[i];
        }
        // if totalMax<=0, all elments in nums are less or equal than 0
        return totalMax>0 ? Math.max(totalMax, sum-totalMin) : totalMax;
    }
}