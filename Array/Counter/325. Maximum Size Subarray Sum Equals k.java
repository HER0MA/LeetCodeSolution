// t:n s:n
class Solution {
    /* if sum[m]-sum[n]==k
     * num[n+1]+...+num[m] == k
     * len = m-n
     * use hashmap store each sum and its index
     */

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // to ensure num[0]+...+num[i]==k has correct result
        map.put(0, -1);
        // change nums to sum
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]-k)) {
                res = Math.max(res, i-map.get(nums[i]-k));
            }
            // need longest subarray
            // so retain the one with smaller index for each sum
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}