// t:n s:1
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <2) return;
        // find the first small-large pair
        // lowest digit i which nums[i]<nums[i+1]
        int firstSmaller = -1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                firstSmaller = i;
                break;
            }
        }
        if (firstSmaller == -1) {
            // no small-large pair, nums is largest permutation, reverse it
            reverse(nums, 0, nums.length-1);
            return;
        }
        // find the smallest number afer firstSmaller which larger than firstSmaller
        // find min(nums[i]) satisfy the condition i>firstSmaller && nums[i]>nums[firstSmaller]
        // smallestLarger always exist
        int smallestLarger = -1;
        for (int i=nums.length-1; i>firstSmaller; i--) {
            if (nums[i]>nums[firstSmaller]) {
                smallestLarger = i;
                break;
            }
        }
        swap(nums, firstSmaller, smallestLarger);
        // after swap, array after firstSmaller is monotonous decreasing
        // reverse it to make it smallest
        reverse(nums, firstSmaller+1, nums.length-1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i<j) {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}