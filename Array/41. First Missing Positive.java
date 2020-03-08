// t:n s:1
// bucket sort, store (i+1) in nums[i]
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            // x should be placed on nums[x - 1]
            // nums[i] should be placed on nums[nums[i] - 1]
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
// nums[i]<0 means i+1 exists, index 0 stores information for 1
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<=0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (Math.abs(nums[i])<=nums.length) {
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}