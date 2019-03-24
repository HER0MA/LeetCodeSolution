// t:n^2 s:n^2
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        int count = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res[rowStart][j] = count++;
            }
            if (++rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = count++;
            }
            if (--colEnd < colStart) break;
            for (int j = colEnd; j >= colStart; j--) {
                res[rowEnd][j] = count++;
            }
            if (--rowEnd < rowStart) break;
            for (int i = rowEnd; i >= rowStart; i--) {
                res[i][colStart] = count++;
            }
            colStart++;
        }
        return res;
    }
}