// t:n^2 s:1
class Solution {
    private final static int MOD = 1000000007;
    
    public int threeSumMulti(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum==target) {
                    if (nums[left]==nums[right]) {
                        int len = right-left+1;
                        res += len*(len-1)/2;
                        res %= MOD;
                        break;
                    } else {
                        left ++;
                        int leftLen = 1;
                        while (nums[left]==nums[left-1]) {
                            left ++;
                            leftLen ++;
                        }
                        right --;
                        int rightLen = 1;
                        while (nums[right]==nums[right+1]) {
                            right --;
                            rightLen ++;
                        }
                        res += leftLen*rightLen;
                        res %= MOD;
                    }
                } else if (sum<target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return res;
    }
}
// t:n^2 s:n^2
class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i=1; i<A.length; i++) {
            res += map.getOrDefault(target-A[i], 0);
            res %= 1000000007;
            for (int j=0; j<i; j++) {
                int sum = A[i] + A[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        return res;
    }
}