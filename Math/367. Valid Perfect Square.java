// t:logn s:1
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num==1) return true;
        int start = 1;
        int end = num;
        while (start+1<end) {
            int mid = start + (end-start)/2;
            long square = (long) mid * mid;
            if (square==num) {
                return true;
            } else if (square>num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start*start==num || end*end==num;
    }
}