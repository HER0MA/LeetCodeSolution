class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, board);
    }
    
    private boolean solve(int num, char[][] board) {
        for (int k = num; k < 81; k++) {
            int i = k / 9;
            int j = k % 9;
            if (board[i][j] == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(i, j, ch, board)) {
                        board[i][j] = ch;
                        if (solve(k + 1, board)) return true;
                        board[i][j] = '.';
                    }
                }
                // all possibilities tried 
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(int i, int j, char ch, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch || board[k][j] == ch
                || board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}