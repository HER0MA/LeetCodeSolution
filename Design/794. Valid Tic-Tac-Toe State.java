class Solution {
    public boolean validTicTacToe(String[] board) {
        int rows[] = new int[3];
        int cols[] = new int[3];
        int diag1 = 0;
        int diag2 = 0;
        int turns = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X') {
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j) diag1++;
                    if (i + j == 2) diag2++;
                } else if (ch == 'O') {
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if (i == j) diag1--;
                    if (i + j == 2) diag2--;
                }
            }
        }
        if (turns < 0 || turns > 1) return false;
        boolean xWin = false;
        boolean oWin = false;
        for (int i = 0; i < 3; i++) {
            if (rows[i] == 3 || cols[i] == 3) xWin = true;
            if (rows[i] == -3 || cols[i] == -3) oWin = true;
        }
        if (diag1 == 3 || diag2 == 3) xWin = true;
        if (diag1 == -3 || diag2 == -3) oWin = true;
        if (xWin && oWin) return false;
        return xWin && turns == 1 || oWin && turns == 0 || !xWin && !oWin;
    }
}