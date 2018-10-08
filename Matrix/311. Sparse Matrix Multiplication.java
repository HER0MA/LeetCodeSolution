// t: A.length * A[0].length * b[0].length
// s: A.length * b[0].length
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i=0; i<A.length; i++) {
            for (int k=0; k<A[0].length; k++) {
                if (A[i][k]!=0) {
                    for (int j=0; j<B[0].length; j++) {
                       res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return res;
    }
}