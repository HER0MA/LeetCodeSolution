// t:m*n s:m*n
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, Integer.MIN_VALUE, matrix, cache));
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int min, int[][] matrix, int[][] cache) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length || matrix[i][j] <= min) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int res =           dfs(i - 1, j, matrix[i][j], matrix, cache) + 1;
        res = Math.max(res, dfs(i, j - 1, matrix[i][j], matrix, cache) + 1);
        res = Math.max(res, dfs(i + 1, j, matrix[i][j], matrix, cache) + 1);
        res = Math.max(res, dfs(i, j + 1, matrix[i][j], matrix, cache) + 1);
        cache[i][j] = res;
        return res;
    }
}
// t:m*n s:m*n
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, matrix, cache));
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int res = 1;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j])
            res = Math.max(res, dfs(i - 1, j, matrix, cache) + 1);
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j])
            res = Math.max(res, dfs(i, j - 1, matrix, cache) + 1);
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j])
            res = Math.max(res, dfs(i + 1, j, matrix, cache) + 1);
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j])
            res = Math.max(res, dfs(i, j + 1, matrix, cache) + 1);
        cache[i][j] = res;
        return res;
    }
}