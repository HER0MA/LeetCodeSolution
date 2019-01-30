// t:n s:1
// same[i] = diff[i-1]
// diff[i] = (same[i-1]+diff[i-1])*(k-1)
class Solution {
    public int numWays(int n, int k) {
        if (n==0) return 0;
        if (n==1) return k;
        int same = k; // same[1]
        int diff = k*(k-1); // diff[1]
        for (int i=2; i<n; i++) {
            int prevSame = same;
            same = diff;
            diff = (prevSame+diff)*(k-1);
        }
        return same+diff;
    }
}