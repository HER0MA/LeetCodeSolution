// t:m*n s:1
// reversely add hits bricks back
class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] --;
        }
        // dfs to mark bricks connected to top
        for (int j=0; j<grid[0].length; j++) {
            dfs(0, j, grid);
        }
        for (int idx=hits.length-1; idx>=0; idx--) {
            int i = hits[idx][0];
            int j = hits[idx][1];
            // add brick back and check if it is connected to top
            if (++grid[i][j]==1 && isConnected(i, j, grid)) {
                res[idx] = dfs(i, j, grid)-1;
            } else {
                res[idx] = 0;
            }
        }
        return res;
    }
    
    private boolean isConnected(int i, int j, int[][] grid) {
        return  i==0 || 
                i-1>=0 && grid[i-1][j]==2 ||
                j-1>=0 && grid[i][j-1]==2 ||
                i+1<grid.length && grid[i+1][j]==2 ||
                j+1<grid[0].length && grid[i][j+1]==2;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        if (i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]!=1) return 0;
        grid[i][j] = 2;
        int res = 1;
        res += dfs(i-1, j, grid);
        res += dfs(i, j-1, grid);
        res += dfs(i+1, j, grid);
        res += dfs(i, j+1, grid);
        return res;
    }
}