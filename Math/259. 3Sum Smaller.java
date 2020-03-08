// t:n^2 s:1
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length- 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] < target - nums[k]) {
                    res += j - i;
                    i++;
                } else {
                    j--;
                }
            }
        }
        return res;
    }
}