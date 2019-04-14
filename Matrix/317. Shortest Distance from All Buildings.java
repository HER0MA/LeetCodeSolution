// t:(mn)^2 s:mn
class Solution {
    private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int shortestDistance(int[][] grid) {
        if (grid.length ==0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int buildingNum = 0;
        int[][] dis = new int[m][n];
        int[][] num = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(i, j, grid, dis, num);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dis[i][j] != 0 && num[i][j] == buildingNum) {
                    res = Math.min(res, dis[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    // t:mn
    private void bfs(int row, int col, int[][] grid, int[][] dis, int[][] num) {
        int m = grid.length;
        int n = grid[0].length;
        // points in queue are points visited, avoid duplicate
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        boolean[][] visited = new boolean[m][n];
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n 
                            &&grid[i][j] == 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        dis[i][j] += distance;
                        num[i][j]++;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            distance++;
        }
        
    }
    
}