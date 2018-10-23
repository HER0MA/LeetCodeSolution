// t:n s:1
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int index = left;
        int right = nums.length-1;
        while (index<=right) {
            if (nums[index]==0) {
                /* swap index, left
                 * nums[left] is already visited by index
                 * all 2 have been moved to right
                 * after swap, nums[index] can be
                 * 0 (index==left) or 1 (index>left)
                 * move index right 
                 */
                nums[index++] = nums[left];
                nums[left++] = 0;
            } else if (nums[index]==2) {
                // swap index, right
                // nums[right] is not visited by index
                // after swap, nums[index] can be 0 or 1 or 2
                // need to check nums[index] again
                nums[index] = nums[right];
                nums[right--] = 2;
            } else {
                index++;
            }
        }
    }
}