class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(0, new int[n], res);
        return res;
    }
    // queens[i] means index of Q in ith row
    private void helper(int row, int[] queens, List<List<String>> res) {
        if (row == queens.length) {
            addRes(queens, res);
            return;
        }
        // try each position in (index)th row
        for (int col=0; col<queens.length; col++) { // O(n)
            queens[row] = col;
            if (isValid(row, queens)) { // O(n)
                helper(row+1, queens, res);
            }
        }
    }
    private boolean isValid(int row, int[] queens) {
        for (int i=0; i<row; i++) {
            if (queens[i]==queens[row]) { // same column
                return false;
            }
            if (i+queens[i]==row+queens[row] || i-queens[i]==row-queens[row]) { // diagonal
                return false;
            }
        }
        return true;
    }
    private void addRes(int[] queens, List<List<String>> res) {
        int n = queens.length;
        List<String> curr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (j==queens[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            curr.add(sb.toString());
        }
        res.add(curr);
    }
}