// t:m*n s:n
/**
 * state from princess room and caculate reversely
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] state = new int[n];
        state[n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        for (int j=n-2; j>=0; j--) {
            state[j] = Math.max(state[j+1]-dungeon[m-1][j], 1);
        }
        for (int i=m-2; i>=0; i--) {
            state[n-1] = Math.max(state[n-1]-dungeon[i][n-1], 1);
            for (int j=n-2; j>=0; j--) {
                int down = Math.max(state[j]-dungeon[i][j], 1);
                int right = Math.max(state[j+1]-dungeon[i][j], 1);
                state[j] = Math.min(down, right);
            }
        }
        return state[0];
    }
}

// t:m*n s:m*n
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] state = new int[m][n];
        state[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        for (int i=m-2; i>=0; i--) {
            state[i][n-1] = Math.max(state[i+1][n-1]-dungeon[i][n-1], 1);
        }
        for (int j=n-2; j>=0; j--) {
            state[m-1][j] = Math.max(state[m-1][j+1]-dungeon[m-1][j], 1);
        }
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                int right = Math.max(state[i][j+1]-dungeon[i][j], 1);
                int down = Math.max(state[i+1][j]-dungeon[i][j], 1);
                state[i][j] = Math.min(right, down);
            }
        }
        return state[0][0];
    }
}