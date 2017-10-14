class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for(int i=len-1; i>=0; i--){
            for(int j=i; j<len; j++){
                //System.out.println(i+" "+j);
                dp[i][j] = j-i<=1 || (dp[i+1][j-1] && A[j]-A[j-1] == A[i+1]-A[i] && A[i+1]-A[i] == A[i+2]-A[i+1]);
                if(j-i>1 && dp[i][j]) ans ++;
            }
        }
        return ans;
    }
}

//数组越界问题的解决