// t:? s:?
class Solution {
    private int count;
    public int uniquePathsIII(int[][] grid) {
        count = 0;
        int totalStep = 0;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) totalStep++;
                else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        totalStep++;
        dfs(startX - 1, startY, 1, totalStep, grid);
        dfs(startX, startY - 1, 1, totalStep, grid);
        dfs(startX + 1, startY, 1, totalStep, grid);
        dfs(startX, startY + 1, 1, totalStep, grid);
        return count;
    }
    
    private void dfs(int i, int j, int step, int totalStep, int[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        if (grid[i][j] == 2) {
            if (step == totalStep) {
                count++;
            }
            return;
        }
        if (grid[i][j] != 0) return;
        grid[i][j] = 3;
        dfs(i - 1, j, step + 1, totalStep, grid);
        dfs(i, j - 1, step + 1, totalStep, grid);
        dfs(i + 1, j, step + 1, totalStep, grid);
        dfs(i, j + 1, step + 1, totalStep, grid);
        grid[i][j] = 0;
    }
}