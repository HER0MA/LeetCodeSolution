// t:n s:1
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (left<=right && product >= k) {
                product /= nums[left++];
            }
            // product<k or left==right+1(res += 0)
            // if product<k, [left, right] is a valid subarray
            // add number of subarrays containing nums[right]
            // subarrays do not contain nums[right] have been added
            res += right-left+1;
            right ++;
        }
        return res;
    }
}