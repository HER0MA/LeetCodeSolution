class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums.clone();
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums==null) return null;
        int[] res = nums.clone();
        for (int i=0; i<res.length; i++) {
            int j = rand.nextInt(i+1);
            swap(i, j, res);
        }
        return res;
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */