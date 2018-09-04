// t:n s:n
class Solution {
    public int maximumGap(int[] nums) {
        if (nums==null || nums.length<2) return 0;
        // find max and min
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        // get max and min of each bucket
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] bucketMax = new int[nums.length-1];
        int[] bucketMin = new int[nums.length-1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num==min || num==max) continue;
            int bucket = (num-min) / gap;
            bucketMax[bucket] = Math.max(bucketMax[bucket], num);
            bucketMin[bucket] = Math.min(bucketMin[bucket], num);
        }
        /*
         * Suppose there are N elements and they range from A to B.
         * Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
         * Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)]
         * then we will have at most num = (B - A) / len + 1 of buckets
         * In each bucket, max - min is smaller than length of bucket
         * length of bucket is the smallest possible gap
         * so we do not care gap inside each bucket
         */
        int res = 0;
        int pre = min;
        for (int i=0; i<nums.length-1; i++) {
            if (bucketMax[i]==Integer.MIN_VALUE && bucketMin[i]==Integer.MAX_VALUE) continue;
            res = Math.max(res, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}