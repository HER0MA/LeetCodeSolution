// forget count++

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        if(matrix.length==0 || matrix[0].length==0) return ans;
        int xStart = 0;
        int yStart = 0;
        int xEnd = matrix[0].length;
        int yEnd = matrix.length;
        int total = matrix[0].length*matrix.length;
        int count = 0;
        while(count<total){
            for(int i=xStart; i<xEnd; i++){
                ans.add(matrix[yStart][i]);
                count++;
            }
            yStart++;
            if(count>=total) break;
            for(int j=yStart; j<yEnd; j++){
                ans.add(matrix[j][xEnd-1]);
                count++;
            }
            xEnd--;
            if(count>=total) break;
            for(int i=xEnd-1; i>=xStart; i--){
                ans.add(matrix[yEnd-1][i]);
                count++;
            }
            yEnd--;
            if(count>=total) break;
            for(int j=yEnd-1; j>=yStart; j--){
                ans.add(matrix[j][xStart]);
                count++;
            }
            xStart++;
        }
        return ans;
    }
}