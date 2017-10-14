class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        int xStart = 0;
        int yStart = 0;
        int xEnd = n;
        int yEnd = n;
        while(count<=n*n){
            for(int i=xStart; i<xEnd; i++){
                ans[yStart][i] = count++;
            }
            yStart++;
            if(count>n*n) break;
            for(int j=yStart; j<yEnd; j++){
                ans[j][xEnd-1] = count++;
            }
            xEnd--;
            if(count>n*n) break;
            for(int i=xEnd-1; i>=xStart; i--){
                ans[yEnd-1][i] = count++;
            }
            yEnd--;
            if(count>n*n) break;
            for(int j=yEnd-1; j>=yStart; j--){
                ans[j][xStart] = count++;
            }
            xStart++;
        }
        return ans;
    }
}