// t:target*n s:target
/* 
 * state[s][i] = state[s][i - 1] + state[s - nums[i - 1]][i - 1]
 * s1 + s2 = sum
 * s1 - s2 = S
 * 2 * s2 = sum - S
 */
// 0-1 knapsack
/*
for (int i = 1; i <= n; i++) {
    for (int v = V; v >= c[i]; v--) {
        f[v] = Math.max(f[v], f[v - c[i]] + w[i]);
    }
}
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        S = Math.abs(S);
        if (sum < S || (sum - S) % 2 != 0) return 0;
        int target = (sum - S) / 2;
        int[] state = new int[target + 1];
        state[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int s = target; s >= nums[i]; s--) {
                state[s] += state[s - nums[i]];
            }
        }
        return state[target];
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        S = Math.abs(S);
        if (sum < S || (sum - S) % 2 != 0) return 0;
        int target = (sum - S) / 2;
        int[] state = new int[target + 1];
        state[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0) state[0] *= 2;
            for (int s = target; s > 0; s--) {
                if (s >= nums[i - 1]) {
                    state[s] += state[s - nums[i-1]];
                }
            }
        }
        return state[target];
    }
}
// t:target*n s:target*n
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        S = Math.abs(S);
        if (sum < S || (sum - S) % 2 != 0) return 0;
        int target = (sum - S) / 2;
        int[][] state = new int[target + 1][nums.length + 1];
        state[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            state[0][i] = state[0][i - 1];
            if (nums[i - 1] == 0) state[0][i] *= 2;
            for (int s = 1; s <= target; s++) {
                state[s][i] = state[s][i - 1];
                if (s >= nums[i - 1]) {
                    state[s][i] += state[s - nums[i-1]][i - 1];
                }
            }
        }
        return state[target][nums.length];
    }
}