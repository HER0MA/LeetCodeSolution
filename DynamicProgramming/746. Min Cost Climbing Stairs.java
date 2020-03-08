// t:n s:n
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int[] state = new int[cost.length + 1];
        state[0] = 0;
        state[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            state[i] = Math.min(state[i - 1] + cost[i - 1], state[i - 2] + cost[i - 2]);
        }
        return state[cost.length];
    }
}