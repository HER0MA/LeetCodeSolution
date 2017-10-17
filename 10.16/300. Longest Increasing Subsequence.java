class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i] && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                    if(dp[i]>max) max = dp[i];
                }
            }
        }
        return max;
    }
}