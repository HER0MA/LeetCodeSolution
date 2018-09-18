// t:m*n? s:1
class Solution {
    public void solve(char[][] board) {
        if (board==null || board.length==0 || board[0]==null || board[0].length==0) return;
        for (int i=0; i<board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length-1, board);
        }
        for (int j=0; j<board[0].length; j++) {
            dfs(0, j, board);
            dfs(board.length-1, j, board);
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]=='F') {
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board) {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O') return;
        board[i][j] = 'F';
        dfs(i-1, j, board);
        dfs(i, j-1, board);
        dfs(i+1, j, board);
        dfs(i, j+1, board);
    }
}