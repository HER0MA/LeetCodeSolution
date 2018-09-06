// t:m*n s:1
class Solution {
    public void gameOfLife(int[][] board) {
        if (board==null || board[0]==null || board.length==0 || board[0].length==0) return;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int count = countNeighbour(board, i, j);
                /* 0->1 2
                 * 1->0 -1
                 */
                if (board[i][j]==1 && !(count==2||count==3) ) board[i][j]=-1;
                if (board[i][j]==0 && count==3) board[i][j]=2;
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                board[i][j] = board[i][j]>0 ? 1 : 0;
            }
        }
    }
    private int countNeighbour(int[][] board, int i, int j) { // O(1)
        int count = 0;
        for (int row=Math.max(i-1, 0); row<=Math.min(i+1, board.length-1); row++) {
            for (int col=Math.max(j-1, 0); col<=Math.min(j+1, board[0].length-1); col++) {
                if (row==i && col==j) continue;
                if (Math.abs(board[row][col])==1) {
                    count ++;
                }
            }
        }
        return count;
    }
}