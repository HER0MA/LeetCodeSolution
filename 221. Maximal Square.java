class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        // a line or a row if(matrix.)
        int yTotal = matrix.length;
        int xTotal = matrix[0].length;
        int[][] matrixNum = new int[yTotal][xTotal];
        for(int j=0; j<yTotal; j++){
            for(int i=0; i<xTotal; i++){
                matrixNum[j][i] = matrix[j][i] - '0';
            }
        }
        int[][] ans = new int[yTotal][xTotal];
        int max = 0;
        for(int i=0; i<xTotal; i++){
            if(matrixNum[0][i]==1){
                ans[0][i]=1;
                max = 1;
            }
        }
        for(int j=1; j<yTotal; j++){
            if(matrixNum[j][0]==1){
                ans[j][0]=1;
                max = 1;
            }
        }
        boolean flag = false;
        for(int j=1; j<yTotal; j++){
            for(int i=1; i<xTotal; i++){
                if(matrixNum[j][i]==0) ans[j][i]=0;
                else{
                    flag = false;
                    for(int r=0; r<=ans[j-1][i-1]; r++){
                        if(matrixNum[j-r][i]==0 || matrixNum[j][i-r]==0 ) {
                            ans[j][i]=r;
                            flag = true;
                            if(r>max) max = r;
                            break;
                        }
                    }
                    if(!flag) {//forget !
                        ans[j][i]=ans[j-1][i-1] + 1;
                        if(ans[j][i]>max) max = ans[j][i];
                    }
                }
            }
        }
        return max*max;
    }
}