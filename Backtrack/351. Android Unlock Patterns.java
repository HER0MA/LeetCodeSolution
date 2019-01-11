// ?t:n!
class Solution {
    private static int[][] skip;
    
    static {
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = 
        skip[2][8] = skip[8][2] = 
        skip[1][9] = skip[9][1] = 
        skip[3][7] = skip[7][3] = 5;
    }
    
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        boolean[] visited = new boolean[10];
        for (int i=m; i<=n; i++) {
            res += dfs(1, i-1, visited)*4; // 1,3,7,9 are same
            res += dfs(2, i-1, visited)*4; // 2,4,6,8 are same
            res += dfs(5, i-1, visited);
        }
        return res;
    }
    
    private int dfs(int curr, int remain, boolean[] visited) {
        if (remain==0) return 1;
        int res = 0;
        visited[curr] = true;
        for (int i=1; i<10; i++) {
            if (!visited[i] && (skip[curr][i]==0 || visited[skip[curr][i]])) {
                res += dfs(i, remain-1, visited);
            }
        }
        visited[curr] = false;
        return res;
    }
}