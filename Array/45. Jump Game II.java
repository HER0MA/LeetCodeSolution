// t:n s:1
class Solution {
    public int jump(int[] nums) {
        if (nums==null || nums.length<2) return 0;
        int count = 0;
        int currMax = 0;
        int nextMax = 0;
        for (int i=0; i<nums.length; i++) {
            nextMax = Math.max(nextMax, i+nums[i]);
            if (nextMax>=nums.length-1) {
                return count+1;
            }
            if (i==currMax) {
                count ++;
                currMax = nextMax;
            }
        }
        return count;
    }
}