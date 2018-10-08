// t:sqrt(c) s:1
class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a<b) {
            long squareSum = (long) b*b + (long)a*a;
            if (squareSum==c) {
                return true;
            } else if (squareSum<c) {
                a++;
            } else {
                b--;
            }
        }
        return a*a*2==c;
    }
}