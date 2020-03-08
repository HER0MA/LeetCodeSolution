// t:n^3 s:n^2
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        int[] sum = new int[n];
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = piles[i] + sum[i + 1];
        }
        return helper(0, 1, piles, sum, memo);
    }
    
    private int helper(int i, int m, int[] piles, int[] sum, int[][] memo) {
        if (i == piles.length) return 0;
        if (2 * m + i >= piles.length) {
            return sum[i];
        }
        if (memo[i][m] != 0) return memo[i][m];
        // Minimize your opponent's earnings
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= m * 2; k++) {
            min = Math.min(min, helper(i + k, Math.max(m, k), piles, sum, memo));
        }
        memo[i][m] = sum[i] - min;
        return memo[i][m];
    }
}