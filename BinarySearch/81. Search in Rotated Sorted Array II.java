// t:logn (worst n) s:1
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums==null || nums.length==0) return false;
        int start = 0;
        int end = nums.length - 1;
        if (nums[start]==target || nums[end]==target) return true;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid]==target) {
                return true;
            // nums[mid]!=target, nums[start]!=target, nums[end]!=target
            } else if (nums[mid]>nums[start]) {
                if (target>nums[start] && target<nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid]<nums[start]) {
                if (target>nums[mid] && target<nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else { //nums[mid]==nums[start]
                start++;
            }
        }
        return nums[start]==target || nums[end]==target;
    }
}