// t:nlogn s:n
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int size = 0;
        /**
         * for each number num in nums
         * insert it into array, replace the least number that >= num
         * result is the size of array (records max length of subsequence)
         */
        int[] array = new int[nums.length];
        for (int num : nums) {
            int pos = replacePos(num, size, array);
            array[pos] = num;
            if (pos==size) size++;
        }
        return size;
    }
    // binary search find the posistion to replace old value with x
    private int replacePos(int x, int size, int[] nums) {
        if (size==0 || nums[0]>=x) return 0;
        if (nums[size-1]<x) return size;
        int start = 0;
        int end = size-1;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid]<x) {
                start = mid;
            } else { // nums[mid]==x search front half
                end = mid;
            }
        }
        // Finally, nums[start]<x, nums[end]>=x
        return end;
    }
}