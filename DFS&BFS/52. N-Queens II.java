// t:n^n s:n
class Solution {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        helper(0, n, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return res;
    }
    /**
     * cols[i] whether column i is occupied
     * d1[i] whether diagnal (row-col+n = i) is occupied
     *      row-col = constant range [-(n-1), n-1]
     *      row-col+n range [1, 2n-1]
     *      need 2n space to store row-col+n
     * d2[i] whether diagnal (row+col = i) is occupied
     *      row+col = constant range [0, 2n-2]
     *      need 2n space to store row+col
     *
     * just do backtrack, no result is recorded
     */
    private void helper(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row==n) {
            res++;
            return;
        }
        for (int col=0; col<n; col++) {
            if (!cols[col] && !d1[row-col+n] && !d2[row+col]) {
                cols[col] = true;
                d1[row-col+n] = true;
                d2[row+col] = true;
                helper(row+1, n ,cols, d1, d2);
                cols[col] = false;
                d1[row-col+n] = false;
                d2[row+col] = false;
            }
        }
    }
}


public class NQueensII {
    int res = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // row
        boolean[] d1 = new boolean[2 * n]; //  \
        boolean[] d2 = new boolean[2 * n]; //  /
        helper(0, cols, d1, d2, n);
        return res;
    }
    public void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            helper(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}