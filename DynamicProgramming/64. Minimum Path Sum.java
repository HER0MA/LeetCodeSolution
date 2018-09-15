// t:m*n s:n
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        res[0] = grid[0][0];
        for (int j=1; j<n; j++) {
            res[j] = res[j-1] + grid[0][j];
        }
        for (int i=1; i<m; i++) {
            res[0] = res[0] + grid[i][0];
            for (int j=1; j<n; j++) {
                res[j] = Math.min(res[j-1], res[j]) + grid[i][j];
            }
        }
        return res[n-1];
    }
}