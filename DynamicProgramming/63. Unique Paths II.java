// t:m*n s:n
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        res[0] = 1;
        // caculate row by row
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0]==1) res[0] = 0;
            for (int j=1; j<n; j++) {
                res[j] = obstacleGrid[i][j]==1 ? 0 : res[j-1] + res[j];
            }
        }
        return res[n-1];
    }
}
// t:m*n s:m*n
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0]==1) break;
            res[i][0] = 1;
        }
        for (int i=0; i<n; i++) {
            if (obstacleGrid[0][i]==1) break;
            res[0][i] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j]==1) continue;
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}