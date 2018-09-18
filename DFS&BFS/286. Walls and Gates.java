// t:m*n*(m*n)?? s:m*n
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j]==0) {
                    dfs(i, j, 0, rooms);
                }
            }
        }
    }
    private void dfs(int i, int j, int dis, int[][] rooms) {
        /**
         * rooms[i][j]<=dis contains 
         * 1)-1 
         * 2)0 
         * 3)already found better route
         */
        if (i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j]<=dis) return;
        rooms[i][j] = dis;
        dfs(i-1, j, dis+1, rooms);
        dfs(i, j-1, dis+1, rooms);
        dfs(i+1, j, dis+1, rooms);
        dfs(i, j+1, dis+1, rooms);
    }
}