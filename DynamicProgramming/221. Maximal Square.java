// t:m*n s:m*n
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int[][] state = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for (int i=1; i<state.length; i++) {
            for (int j=1; j<state[0].length; j++) {
                if (matrix[i-1][j-1]=='1') {
                    state[i][j] = Math.min(Math.min(state[i-1][j], state[i][j-1]), state[i-1][j-1]) + 1;
                    res = Math.max(res, state[i][j]);
                }
            }
        }
        return res*res;
    }
}