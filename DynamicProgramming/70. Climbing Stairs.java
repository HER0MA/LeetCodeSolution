// t:n s:1
class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int res = 0;
        twoStep = 1;
        oneStep = 1;
        for (int i=2; i<=n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }
}
// t:n s:n
class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i=2; i<=n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
}
// Another Solution is recursion