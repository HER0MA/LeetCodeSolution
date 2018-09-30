// t:logn s:1
class Solution {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) return -1;
        int start = 0;
        int end = nums.length-1;
        // no rotated array
        if (nums[end]>nums[start]) return nums[start];
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid]<nums[start]) {
                end = mid;
            } else { // nums[mid] > nums[start]
                start = mid;
            }
        }
        // [start, end]
        //   max   min
        return nums[end];
    }
}