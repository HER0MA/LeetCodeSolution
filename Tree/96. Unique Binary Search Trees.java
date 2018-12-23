// t:n^2 s:n
class Solution {
    public int numTrees(int n) {
        int[] state = new int[n+1];
        state[0] = 1;
        state[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<i; j++) {
                // number of nodes in left:  0   ~ i-1
                // number of nodes in right: i-1 ~ 0
                state[i] += state[j]*state[i-1-j];
            }
        }
        return state[n];
    }
}