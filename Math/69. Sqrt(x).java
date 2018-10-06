class Solution {
    public int mySqrt(int x) {
        if (x<2) return x;
        int start = 1;
        int end = x;
        while (start+1<end) {
            int mid = start + (end-start)/2;
            long square = (long) mid * mid;
            if (square==x) {
                return mid;
            } else if (square<x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // overflow when x is large enough if no (long)
        return (long) end*end<x ? end : start;
    }
}