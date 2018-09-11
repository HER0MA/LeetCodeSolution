// t:n^3 s:n^2
class Solution {
    public int maxCoins(int[] nums) {
        int[] coin = new int[nums.length+2];
        coin[0] = 1;
        coin[coin.length-1] = 1;
        for (int i=1; i<coin.length-1; i++) {
            coin[i] = nums[i-1];
        }
        /**
         * res[i][j] means the maximum coin you can get
         * if you break all balloons between i and j (not include i and j)
         * res[i][j] = max{coin[i]*coin[k]*coin[j]+res[i][k]+res[k][k]} 
         * for all k in (i,j)
         */
        int[][] res = new int[coin.length][coin.length];
        for (int d=2; d<coin.length; d++) {
            for (int i=0; i+d<coin.length; i++) {
                int j = i + d;
                for (int k=i+1; k<j; k++) {
                    res[i][j] = Math.max(res[i][j], coin[i]*coin[k]*coin[j] + res[i][k] + res[k][j]);
                }
            }
        }
        return res[0][coin.length-1];
    }
}