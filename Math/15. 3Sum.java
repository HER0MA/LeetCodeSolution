// t:n^2 s:n
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length<3) return res;
        Arrays.sort(nums);
        int i = 0;
        while (i<nums.length-2) {
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[left]+nums[right]==-nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left = moveRight(nums, left);
                    right = moveLeft(nums, right);
                } else if (nums[left]+nums[right]<-nums[i]) {
                    left = moveRight(nums, left);
                } else {
                    right = moveLeft(nums, right);
                }
            }
            i = moveRight(nums, i);
        }
        return res;
    }
    private int moveRight(int[] nums, int i) {
        i++;
        while (i<nums.length && nums[i]==nums[i-1]) {
            i++;
        }
        return i;
    }
    private int moveLeft(int[] nums, int i) {
        i--;
        while (i>=0 && nums[i]==nums[i+1]) {
            i--;
        }
        return i;
    }
}