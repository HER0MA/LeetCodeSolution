// t:n*amount s:amount
//complete knapsack
/*
for (int i = 1; i <= n; i++) {
    for (int v = c[i]; v <= V; v++) {
        f[v] = Math.max(f[v], f[v - c[i]] + w[i]);
    }
}
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] state = new int[amount + 1];
        Arrays.fill(state, Integer.MAX_VALUE);
        state[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int s = coins[i]; s <= amount; s++) {
                if (state[s - coins[i]] != Integer.MAX_VALUE) {
                    state[s] = Math.min(state[s], state[s - coins[i]] + 1);
                }
            }
        }
        return state[amount] == Integer.MAX_VALUE ? -1 : state[amount];
    }
}
// state[s][i] = min{state[s][i - 1], state[s - coins[i]][i] + 1}
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] state = new int[amount + 1];
        Arrays.fill(state, Integer.MAX_VALUE);
        state[0] = 0;
        for (int s = 1; s <= amount; s++) {
            for (int i = 0; i < coins.length; i++) {
                // res[k]==Integer.MAX_VALUE -> amount k can not be changed
                if (s >= coins[i] && state[s - coins[i]] != Integer.MAX_VALUE) {
                    state[s] = Math.min(state[s], state[s - coins[i]] + 1);
                }
            }
        }
        return state[amount] == Integer.MAX_VALUE ? -1 : state[amount];
    }
}
// original version
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] state = new int[amount + 1][coins.length + 1];
        for (int s = 1; s < amount + 1; s++) {
            for (int i = 0; i <= coins.length; i++) {
                state[s][i] = Integer.MAX_VALUE;
            }
        }
        for (int s = 1; s < amount + 1; s++) {
            for (int i = 1; i <= coins.length; i++) {
                if (s >= coins[i - 1] && state[s - coins[i - 1]][i] != Integer.MAX_VALUE) {
                    state[s][i] = Math.min(state[s][i - 1], state[s - coins[i - 1]][i] + 1);
                } else {
                    state[s][i] = state[s][i - 1];
                }
            }
        }
        return state[amount][coins.length] == Integer.MAX_VALUE ? -1 : state[amount][coins.length];
    }
}