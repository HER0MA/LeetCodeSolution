// t:logn (wosrst n) s:1
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] > nums[start]) return nums[start];
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid]>nums[start]) {
                start = mid;
            } else if (nums[mid]<nums[start]) {
                end = mid;
            } else { // nums[mid] == nums[start]
                while (start+1<end && nums[start+1]==nums[start]) {
                    start ++;
                }
                if (nums[mid] == nums[end]) {
                    while (start+1<end && nums[end-1]==nums[end]) {
                        end --;
                    }
                }
            }
        }
        return nums[end];
    }
}