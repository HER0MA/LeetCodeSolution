class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int yLength = obstacleGrid.length;
        if(yLength==0) return 0;
        int xLength = obstacleGrid[0].length;
        if(xLength==0) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        if(yLength==1){
            for(int i=0; i<xLength; i++){
                if(obstacleGrid[0][i]==1) return 0;
            }
            return 1;
        }
        if(xLength==1){
            for(int j=0; j<yLength; j++){
                if(obstacleGrid[j][0]==1) return 0;
            }
            return 1;
        }
        if(obstacleGrid[yLength-1][xLength-1]==1) return 0;
        int[][] numPath = new int[yLength][xLength];
        for(int i=0; i<xLength; i++)
            if(obstacleGrid[yLength-1][xLength-1-i]==0)
                numPath[0][i] = 1;
            else{
                numPath[0][i] = -1;
                break;//if there is an obstacle,upper or left of the line should not have path
            }
        for(int j=1; j<yLength; j++)
            if(obstacleGrid[yLength-1-j][xLength-1]==0)// convert the direction
                numPath[j][0] = 1;
            else{
                numPath[j][0] = -1;
                break;
            }
        
        for(int j=1; j<yLength; j++){
            for(int i=1; i<xLength; i++){
                if(obstacleGrid[yLength-1-j][xLength-1-i]==1){
                    numPath[j][i] = -1;
                }else{
                    if(numPath[j-1][i]!=-1) numPath[j][i] += numPath[j-1][i];
                    if(numPath[j][i-1]!=-1) numPath[j][i] += numPath[j][i-1];
                }
            }
        }
        return numPath[yLength-1][xLength-1];
    }
}