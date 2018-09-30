// t:logn s:1
class Solution {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        if (nums[0]==target) return 0;
        int start = 0;
        int end = nums.length - 1;
        if (nums[end]==target) return end;
        while (start+1<end) {
            int mid = start + (end-start)/2;
            if (nums[mid]==target) {
                return mid;
            // nums[mid]!=target, nums[start]!=target, nums[end]!=target
            } else if (nums[mid]>nums[start]) {
                if (target>nums[start] && target<nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target>nums[mid] && target<nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start]==target) return start;
        if (nums[end]==target) return end;
        return -1;
    }
}