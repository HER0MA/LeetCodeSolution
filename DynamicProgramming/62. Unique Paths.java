// t:m*n s:n
class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1; // only one way to points in first column
        // caculate row by row
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                // res[i][j] = res[i][j-1] + res[i-1][j]
                res[j] = res[j-1] + res[j];
            }
        }
        return res[n-1];
    }
}
// t:m*n s:m*n
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++) {
            res[i][0] = 1;
        }
        for (int i=0; i<n; i++) {
            res[0][i] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                res[i][j] = res[i-1][j]+res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}
// t:m s:1
/** 
 * Combination
 * m+n-1 steps m-1 down n-1 right
 */
class Solution {
    public int uniquePaths(int m, int n) {
        double res = 1;
        for (int i=1; i<=m-1; i++) {
            res = res * (i+n-1) / i;
        }
        return (int)res;
    }
}