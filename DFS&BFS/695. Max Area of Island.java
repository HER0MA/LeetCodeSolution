// t:m*n s:1
class Solution {
    private int currArea;
    
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                currArea = 0;
                dfs(grid, i, j);
                area = Math.max(area, currArea);
            }
        }
        return area;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || 
            j < 0 || j == grid[0].length || 
            grid[i][j] != 1) return;
        currArea++;
        grid[i][j] = 2;
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
    }
}