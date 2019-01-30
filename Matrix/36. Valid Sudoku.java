// t:n^2s:n
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i=0; i<9; i++) {
            set.clear();
            for (int j=0; j<9; j++) {
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int j=0; j<9; j++) {
            set.clear();
            for (int i=0; i<9; i++) {
                if (board[i][j]=='.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                set.clear();
                for (int i=row*3; i<row*3+3; i++) {
                    for (int j=col*3; j<col*3+3; j++) {
                        if (board[i][j]=='.') continue;
                        if (set.contains(board[i][j])) return false;
                        set.add(board[i][j]);
                    }
                }
                
            }
        }
        return true;
    }
}