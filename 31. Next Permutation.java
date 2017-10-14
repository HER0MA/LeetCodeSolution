class Solution {
    public void nextPermutation(int[] nums) {
        //search from back to front, if there is an inversion, 
        //find the least number behind the inversion,swap least number and invsersion,
        //then sort the number behind inversion
        if(nums.length<=1) return;
        int index = -1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i]) {
                index = i-1;
                break;
            }
        }
        int temp;
        if(index != -1){
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for(int i=nums.length-1; i>index; i--){
                if(nums[i]<min && nums[i]>nums[index]){
                    min = nums[i];
                    minIndex = i;
                }
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[index];
            nums[index] = temp;
        }
        for(int i=index+1; i<nums.length-1; i++){
            for(int j=nums.length-1; j>i; j--){
                if(nums[j]<nums[j-1]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                } 
            }
        }
    }
}