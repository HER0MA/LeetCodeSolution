// dp
// find the point to form a triangle with edge a[i]a[j]
// t:n^3 s:n^2
class Solution {
    public int minScoreTriangulation(int[] a) {
        int[][] state = new int[a.length][a.length];
        for (int diff = 2; diff < a.length; diff++) {
            for (int i = 0; i + diff < a.length; i++) {
                int j = i + diff;
                state[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    state[i][j] = Math.min(state[i][j], state[i][k] + state[k][j] + a[i] * a[j] * a[k]);
                }
            }
        }
        return state[0][a.length - 1];
    }
}