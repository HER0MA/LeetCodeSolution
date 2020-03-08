// t:n^2 s:n
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLen = 1;
        int maxCount = 1;
        int[] count = new int[nums.length];
        int[] len = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(len, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                if (len[i] == len[j] + 1) {
                    count[i] += count[j];
                } else if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    count[i] = count[j];
                }
            }
            if (len[i] == maxLen) {
                maxCount += count[i];
            } else if (len[i] > maxLen) {
                maxLen = len[i];
                maxCount = count[i];
            }
        }
        return maxCount;
    }
}