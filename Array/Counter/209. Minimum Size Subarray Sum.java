// t:n s:1
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        // two pointers, sum is sum of nums between j and i
        for (int i=0, j=0; i<nums.length; i++) {
            sum += nums[i];
            while (j<=i && sum>=s) {
                res = Math.min(res, i-j+1);
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}