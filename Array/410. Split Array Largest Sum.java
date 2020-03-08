// t:nlogn*len(nums) (n = sum - max) s:1
class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        long left = max;
        long right = sum;
        /**
         * The result between max and sum
         * use binary search to find the result
         */
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (isValid(mid, nums, m)) {
                // enough groups, try smaller limit
                right = mid;
            } else {
                // too many groups, try larger limit
                left = mid;
            }
        }
        if (isValid(left, nums, m)) return (int)left;
        return (int)right;
    }
    
    // if we can have less than m of groups, each group has sum no larger than target
    private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                sum = nums[i];
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}