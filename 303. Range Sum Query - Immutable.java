class NumArray {
    private int[] numbers;
    private int[] numSum;
    public NumArray(int[] nums) {
        numbers = nums;
        numSum = new int[nums.length];
        if(nums.length!=0){
            numSum[0] = nums[0];
            for(int i=1;i<nums.length; i++){
                numSum[i] = numSum[i-1]+nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return numSum[j];
        else return numSum[j] - numSum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */