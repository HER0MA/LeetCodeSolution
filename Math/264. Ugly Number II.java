// t:n s:n
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int idx2=0, idx3=0, idx5=0;
        for (int i=1; i<n; i++) {
            nums[i] = Math.min(nums[idx2]*2, Math.min(nums[idx3]*3, nums[idx5]*5));
            // ensure n[i2]*2, n[i3]*3, n[i5]*5 are all always than current ugly number
            // if equal, move idx to make it larger
            if (nums[i]==nums[idx2]*2) idx2++;
            if (nums[i]==nums[idx3]*3) idx3++;
            if (nums[i]==nums[idx5]*5) idx5++;
        }
        return nums[n-1];
    }
}