// t:mn s:mn
// DFS, start search from edge
class Solution {
    private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        List<List<Integer>> res = new ArrayList();
        if (m == 0 || matrix[0].length == 0) return res;
        int n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] alt = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pac, matrix);
            dfs(i, n - 1, alt, matrix);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pac, matrix);
            dfs(m - 1, j, alt, matrix);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && alt[i][j]) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    private void dfs(int i, int j, boolean[][] visited, int[][] matrix) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || 
                matrix[x][y] < matrix[i][j]) continue;
            dfs(x, y, visited, matrix);
        }
    }
}