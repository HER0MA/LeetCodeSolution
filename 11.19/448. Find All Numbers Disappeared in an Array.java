// if all numbers exist. the whole array will be nagative
// if there is a positive number, that means its index does not exist in the array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) ans.add(i+1);
        }
        return ans;
    }
}