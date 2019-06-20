// t:n*sum s:sum
// 0-1 knapsack
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;
        int target = sum / 2;
        boolean[] state = new boolean[target + 1];
        state[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int s = target; s >= stones[i]; s--) {
                state[s] = state[s] || state[s - stones[i]];
            }
        }
        int smaller = 0;
        for (int s = target; s >= 0; s--) {
            if (state[s]) {
                smaller = s;
                break;
            }
        }
        return sum - 2 * smaller;
    }
}