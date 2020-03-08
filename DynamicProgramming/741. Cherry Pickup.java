// t:n^3 s:n^2
// this question is equal to two people from upper left to lower right
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] state = new int[n][n];
        state[0][0] = grid[0][0];
        for (int step = 1; step < 2 * n - 1; step++) {
            // we need use previous state[i1-1][j1-1]
            // so update from large to small
            for (int i1 = n - 1; i1 >= 0; i1--) {
                for (int i2 = n - 1; i2 >= 0; i2--) {
                    // j can be caculated from i and step
                    int j1 = step - i1;
                    int j2 = step - i2;
                    
                    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
                        // this (i1, j1) (i2, j2) pair is invalid
                        state[i1][i2] = -1;
                        continue;
                    }
                    /* state[step][i1][i2] = Max{state[step - 1][i1]    [i2], 
                     *                           state[step - 1][i1 - 1][i2], 
                     *                           state[step - 1][i1]    [i2 - 1], 
                     *                           state[step - 1][i1 - 1][i2 - 1]}
                     */
                    if (i1 > 0) state[i1][i2] = Math.max(state[i1][i2], state[i1 - 1][i2]);
                    if (i2 > 0) state[i1][i2] = Math.max(state[i1][i2], state[i1][i2 - 1]);
                    if (i1 > 0 && i2 > 0) state[i1][i2] = Math.max(state[i1][i2], state[i1 - 1][i2 - 1]);
                    
                    if (state[i1][i2] != -1) {
                        state[i1][i2] += grid[i1][j1];
                        if (i1 != i2) state[i1][i2] += grid[i2][j2];
                    }
                }
            }
        }
        return state[n - 1][n - 1] == -1 ? 0 : state[n - 1][n - 1];
    }
}