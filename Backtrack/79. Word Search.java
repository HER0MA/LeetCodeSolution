// t:m*n s:len(word)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (helper(0, i, j, board, word)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(int idx, int i, int j, char[][] board, String word) {
        if (idx == word.length()) return true;
        if (idx>word.length() || 
            i<0 || j<0 || i==board.length || j==board[0].length || 
            board[i][j]=='*' || board[i][j]!=word.charAt(idx)) return false;
        char ch = board[i][j];
        board[i][j] = '*';
        boolean res = helper(idx+1, i-1, j, board, word) ||
                      helper(idx+1, i, j-1, board, word) ||
                      helper(idx+1, i+1, j, board, word) ||
                      helper(idx+1, i, j+1, board, word);
        board[i][j] = ch;
        return res;
    }
}