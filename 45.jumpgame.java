class Solution {
    public int jump(int[] nums) {
        if(nums.length==0) return 0;
        int times=0;
        int furthest=0;
        int furthestPrev = 0;
        int furthestSave = 0;
        int furthestPrevSave = 0;
        boolean flag = false;
        while(furthest<nums.length-1){
            flag = false;
            furthestSave = furthest;
            furthestPrevSave = furthestPrev;
            for(int i=furthestPrevSave; i<=furthestSave; i++){
                if(nums[i]+i>furthest){
                    furthestPrev = i+1;
                    furthest = nums[i]+i;
                    flag = true;
                }
            }
            if(flag) times++;
        }
        return times;
    }
}

class Solution {
    public int jump(int[] nums) {
        if(nums.length==0) return 0;
        int[] step = new int[nums.length];// from = new int[nums.length];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[0]=0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j]>=i && step[j]+1<step[i]){
                    step[i] = step[j]+1;
                }
            }
        }
        return step[nums.length-1];
    }
}