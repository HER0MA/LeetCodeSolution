class TicTacToe {
    private int size;
    private int[] rows;
    private int[] cols;
    private int diag1;
    private int diag2;

    /** Initialize your data structure here. */
    // t:1
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    // t:1
    public int move(int row, int col, int player) {
        if (player == 1) {
            if (++rows[row] == size ||
                ++cols[col] == size ||
                row == col && ++diag1 == size ||
                row+col == size-1 && ++diag2 == size) 
                return 1;
        } else {
            if (--rows[row] == -size ||
                --cols[col] == -size ||
                row == col && --diag1 == -size ||
                row+col == size-1 && --diag2 == -size) 
                return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */