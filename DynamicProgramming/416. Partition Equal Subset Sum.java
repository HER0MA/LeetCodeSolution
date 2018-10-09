/**
 * Dynamic Programming, state[i][j] means whether first i numbers can sum to j
 * initial state: state[0][0] = true, state[i][0] = true, state[0][j] = false
 * transition: state[i][j] = state[i-1][j] || state[i-1][j-nums[i-1]]
 * optimize:   state   [j] = state     [j] || state     [j-nums[i-1]]
 */
// t:n*sum s:sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 == 1) return false;
        sum /= 2;
        int n = nums.length;
        boolean[] state = new boolean[sum+1];
        state[0] = true;
        for (int num : nums) {
            // state[i] means whether numbers no later than num can added to i
            // smaller sum should be updated later
            for (int i=sum; i>0; i--) {
                if (i>=num) {
                    state[i] = state[i] || state[i-num];
                }
            }
            if (state[sum]) return true;
        }
        return state[sum];
    }
}
// t:n*sum s:n*sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 == 1) return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] state = new boolean[n+1][sum+1];
        for (int i=0; i<n+1; i++) {
            state[i][0] = true;
        }
        // when j!=0 state[0][j] = false;
        for (int i=1; i<n+1; i++) {
            for (int j=0; j<sum+1; j++) {
                state[i][j] = state[i-1][j];
                // i = index+1 => index = i-1
                if (j>=nums[i-1]) {
                    state[i][j] =  state[i][j] || state[i-1][j-nums[i-1]];
                }
            }
        }
        return state[n][sum];
    }
}