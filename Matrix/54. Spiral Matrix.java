// t:m*n s:m*n
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            if (++rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            if (--colEnd < colStart) break;
            for (int j = colEnd; j >= colStart; j--) {
                res.add(matrix[rowEnd][j]);
            }
            if (--rowEnd < rowStart) break;
            for (int i = rowEnd; i >= rowStart; i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return res;
    }
}