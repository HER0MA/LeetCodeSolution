// t:logn s:1
class Solution {
    public double myPow(double x, int n) {
        return n>0 ? pow(x, n) : 1.0/pow(x, -n);
    }
    private double pow(double x, int n) {
        if (n==0) return 1;
        double y = pow(x, n/2);
        return n%2==0 ? y*y : y*y*x;
    }
}