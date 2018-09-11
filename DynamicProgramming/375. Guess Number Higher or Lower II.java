// t:n^3 s:n^2
/**
 * xk = k + max{res[i][k-1], res[k+1][j]}
 *  the cost to guarantee in range [i,j] if you guess k first
 *  three case:
 *      1. k is target   -> cost = 0
 *      2. target higher -> cost = k + res[k+1][j]
 *      3. target lower  -> cost = k + res[i][k-1]
 *  Since we do not know which case and we need to gurantee a win
 *  So choose maximun value as result
 * res[i][j] = min{xi, ... ,xj}
 *  the minimum cost to guarantee a win in range [i,j]
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] res = new int[n+1][n+1];
        for (int k=1; k<n; k++) {
            for (int i=1; i+k<=n; i++) {
                int j = i+k;
                res[i][j] = i + res[i+1][j];
                for (int x = i+1; x<j; x++) {
                    res[i][j] = Math.min(res[i][j], x + Math.max(res[i][x-1], res[x+1][j]));
                }
                res[i][j] = Math.min(res[i][j], j + res[i][j-1]);
            }
        }
        return res[1][n];
    }
}