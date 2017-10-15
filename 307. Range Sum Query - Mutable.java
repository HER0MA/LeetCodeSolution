class NumArray {
    private int[] number;
    private int groupLen;
    private int[] groupSum;
    public NumArray(int[] nums) {
        number = nums;
        if(nums.length!=0){
            groupLen = (int)Math.sqrt(nums.length);
            groupSum = new int[nums.length/groupLen+1];
            for(int i=0;i*groupLen<nums.length;i++){
                for(int j=0;j<groupLen && i*groupLen+j<number.length;j++){
                    groupSum[i] += nums[i*groupLen+j]; 
                }
            }
        }
    }
    
    public void update(int i, int val) {
        groupSum[i/groupLen] -= (number[i] - val);
        number[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int sum=0;
        int k=i;
        // very complex
        while(k%groupLen!=0 && k<=j){
            sum+=number[k];
            k++;
        }
        while(k+groupLen<=j){
            sum+=groupSum[k/groupLen];
            k+=groupLen;
        }
        while(k<=j){
            sum+=number[k];
            k++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */