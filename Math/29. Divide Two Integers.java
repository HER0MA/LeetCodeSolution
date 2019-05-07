// t:logn s:logn
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long ldividend = dividend;
        long ldivisor = divisor; 
        if (dividend < 0) {
            sign = -1;
            ldividend = -ldividend;
        }
        if (divisor < 0) {
            sign *= -1;
            ldivisor = -ldivisor;
        }
        long res = dividePositive(ldividend, ldivisor);
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)res * sign;
    }
    
    private long dividePositive(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long multiple = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + dividePositive(dividend - sum, divisor);
    }
}