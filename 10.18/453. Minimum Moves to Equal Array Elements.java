class Solution {
    public int minMoves(int[] nums) {
        if(nums.length==1) return 0;
        int min = nums[0];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            min = nums[i]<min ? nums[i] : min;
        }
        for(int i=0; i<nums.length; i++) {
            ans += nums[i] - min;
        }
        return ans;
    }
}