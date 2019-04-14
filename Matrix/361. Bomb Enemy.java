// t:m*n s:n
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    // #(enemies between walls/boundaries in this row)
                    // if false, rowCount have already been calculated
                    rowCount = 0;
                    // each element only visit once by this loop
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCount++;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = 0;
                    // each element only visit once by this loop
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCount[j]++;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCount + colCount[j]);
                }
            }
        }
        return res;
    }
}
// t:m*n s:m*n
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j - 1] == 'W') {
                    left[i][j] = 0;
                } else if (grid[i][j - 1] == 'E') {
                    left[i][j] = left[i][j - 1] + 1;
                } else {
                    left[i][j] = left[i][j - 1];
                }
            }
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j + 1] == 'W') {
                    right[i][j] = 0;
                } else if (grid[i][j + 1] == 'E') {
                    right[i][j] = right[i][j + 1] + 1;
                } else {
                    right[i][j] = right[i][j + 1];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (grid[i - 1][j] == 'W') {
                    up[i][j] = 0;
                } else if (grid[i - 1][j] == 'E') {
                    up[i][j] = up[i - 1][j] + 1;
                } else {
                    up[i][j] = up[i - 1][j];
                }
            }
            for (int i = m - 2; i >= 0; i--) {
                if (grid[i + 1][j] == 'W') {
                    down[i][j] = 0;
                } else if (grid[i + 1][j] == 'E') {
                    down[i][j] = down[i + 1][j] + 1;
                } else {
                    down[i][j] = down[i + 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
                }
            }
        }
        return res;
    }
}