// t:log(mn) s:1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] == target || matrix[m - 1][n - 1] == target) return true;
        int start = 0;
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            if (matrix[mid / n][mid % n] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}