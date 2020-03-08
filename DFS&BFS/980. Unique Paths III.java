// t:n s:1
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startI = -1;
        int startJ = -1;
        int remain = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                } else if (grid[i][j] == 0) {
                    remain++;
                }
            }
        }
        grid[startI][startJ] = 0;
        return dfs(startI, startJ, remain + 1, grid);
        
    }
    
    private int dfs(int i, int j, int remain, int[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return 0;
        if (grid[i][j] == 2) return remain == 0 ? 1 : 0;
        if (grid[i][j] != 0) return 0;
        grid[i][j] = 3;
        int res = dfs(i - 1, j, remain - 1, grid);
        res +=    dfs(i, j - 1, remain - 1, grid);
        res +=    dfs(i + 1, j, remain - 1, grid);
        res +=    dfs(i, j + 1, remain - 1, grid);
        grid[i][j] = 0;
        return res;
    }
}