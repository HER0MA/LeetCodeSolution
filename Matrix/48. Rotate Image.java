// t: n^2 s:1
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return;
        int low = 0;
        int high = matrix.length-1;
        while (low < high) {
            for (int i=0; i<high-low; i++) {
                int temp = matrix[low][low+i];
                matrix[low][low+i] = matrix[high-i][low];
                matrix[high-i][low] = matrix[high][high-i];
                matrix[high][high-i] = matrix[low+i][high];
                matrix[low+i][high] = temp;
            }
            low ++;
            high --;
        }
    }
}