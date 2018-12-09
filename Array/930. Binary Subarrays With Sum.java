// t:n s:n
class Solution {
    public int numSubarraysWithSum(int[] nums, int target) {
        int[] count = new int[nums.length+1];
        int sum = 0;
        int res = 0;
        // choose 0 element is one way to get 0
        count[0] = 1;
        for (int num : nums) {
            sum += num;
            if (sum>=target) {
                // from leftmost to some index i sums to "sum-target"
                // so from i+1 to current index sums to target
                // there are count[sum-target] such indexes, so add them to res
                res += count[sum - target];
            }
            count[sum] ++;
        }
        return res;
    }
}