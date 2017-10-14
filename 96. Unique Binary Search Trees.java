class Solution {
    public int numTrees(int n){
        if(n<=1) return 1;
        int[] table = new int[n+1];
        table[0] = 1;
        table[1] = 1;
        for(int r=2; r<=n; r++){
            for(int i=1; i<=r; i++){
                table[r] += table[i-1] * table[r-i];
            }
        }
        return table[n];
    }
}