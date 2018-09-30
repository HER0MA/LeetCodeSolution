// t:logn s:1
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target<=nums[0]) return 0;
        if (target>nums[nums.length-1]) return nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]<target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // all start value have been checked
        // nums[start] < target is always true
        return end;
    }
}
/**
 * Another solution: (not checking at the begining)
 *  if (target <= nums[start]) {
 *       return start;
 *   } else if (target <= nums[end]) {
 *       return end;
 *   } else {
 *       return end + 1;
 *   }
 */