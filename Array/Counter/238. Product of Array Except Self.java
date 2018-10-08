// t:n s:n
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        // product of all numbers on the right of index i
        int right = 1;
        for (int i=res.length-2; i>=0; i--) {
            right *= nums[i+1];
            res[i] *= right;
        }
        return res;
    }
}