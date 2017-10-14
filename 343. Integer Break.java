class Solution {
    public int integerBreak(int n) {
        int[] maxProduct = new int[n+1];
        // [0X,1X,2,3,4,5]
        maxProduct[0] = 1;
        maxProduct[1] = 1;
        maxProduct[2] = 1;
        int max1 = 0;
        int max2 = 0;
        for(int i=2; i<=n;i++){
            for(int j=1;j<=i/2;j++){
                max1 = maxProduct[j] > j ? maxProduct[j] : j;
                max2 = maxProduct[i-j] > i-j ? maxProduct[i-j] : i-j;
                maxProduct[i] = max1*max2>maxProduct[i] ? max1*max2 : maxProduct[i];
            }
        }
        return maxProduct[n];
    }
}