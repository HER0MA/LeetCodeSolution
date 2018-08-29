// t:n s:1
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int i=0;
        while (i<=max && i<nums.length) {
            max = Math.max(i+nums[i], max);
            i++;
        }
        return i>=nums.length;
    }
}