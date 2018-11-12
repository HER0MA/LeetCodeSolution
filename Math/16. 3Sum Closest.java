// t:n^2 s:1
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length<3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        for (int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                res = Math.abs(sum - target)<Math.abs(res - target) ? sum : res;
                if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return res;
    }
}