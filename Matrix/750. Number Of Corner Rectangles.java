// t:nm^2 s:1
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid.length < 2 ||  grid[0].length < 2) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int r1 = 0; r1 < m - 1; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                int count = 0;
                for (int c = 0; c < n; c++) {
                    if (grid[r1][c] == 1 && grid[r2][c] == 1) count++;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}