// t:n^3 s:n
class Solution {
    public int findCircleNum(int[][] M) {
        int res = M.length;
        int[] roots = new int[M.length];
        Arrays.fill(roots, -1);
        for (int i=1; i<M.length; i++) {
            for (int j=0; j<i; j++) {
                if (M[i][j]==0) continue;
                int rootI = find(i, roots);
                int rootJ = find(j, roots);
                if (rootI!=rootJ) {
                    res --;
                    roots[rootJ] = rootI;
                }
            }
        }
        return res;
    }
    
    private int find(int i, int[] roots) {
        while (roots[i]!=-1) {
            i = roots[i];
        }
        return i;
    }
}