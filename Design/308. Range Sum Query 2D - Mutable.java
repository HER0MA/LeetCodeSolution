// Binary Indexed Tree
// s:m*n
class NumMatrix {
    private int[][] tree;
    // t:m*n
    public NumMatrix(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return;
        tree = new int[matrix.length+1][matrix[0].length+1];
        // initialize each row, then combine rows, else introduce duplicates
        for (int i=1; i<tree.length; i++) {
            for (int j=1; j<tree[0].length; j++) {
                tree[i][j] += matrix[i-1][j-1];
                int jj = j + (j&-j);
                if (jj<tree[0].length) {
                    tree[i][jj] += tree[i][j];
                }
            }
        }
        for (int i=1; i<tree.length; i++) {
            int ii = i + (i&-i);
            if (ii < tree.length) {
                for (int j=1; j<tree[0].length; j++) {
                    tree[ii][j] += tree[i][j];
                }
            }
        }
    }
    // t: logm * logn
    public void update(int row, int col, int val) {
        int delta = val - sumRegion(row, col, row, col);
        for (int i=row+1; i<tree.length; i += i&-i) {
            for (int j=col+1; j<tree[0].length; j += j&-j) {
                tree[i][j] += delta;
            }
        }
    }
    // t: logm * logn
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
    }
    // t: logm * logn
    private int sum(int row, int col) {
        int res = 0;
        for (int i=row+1; i>0; i -= i&-i) {
            for (int j=col+1; j>0; j -= j&-j) {
                res += tree[i][j];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */