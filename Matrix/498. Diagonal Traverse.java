// t:mn s:1
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        boolean isUp = true;
        int idx = 0;
        int i = 0;
        int j = 0;
        while (idx < m * n) {
            if (i >=0 && i < m && j >=0 && j < n) {
                res[idx++] = matrix[i][j];
                if (isUp) {
                    i--;
                    j++;
                } else {
                    i++;
                    j--;
                }
            } else {
                if (isUp) {
                    j++;
                } else {
                    i++;
                }
                isUp = !isUp; 
                while (!(i >=0 && i < m && j >=0 && j < n)) {
                    if (isUp) {
                        i--;
                        j++;
                    } else {
                        i++;
                        j--;
                    }
                }
            }
        }
        return res;
    }
}