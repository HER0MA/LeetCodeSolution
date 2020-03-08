// t:1 s:1
class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= 0) {
            n -= i++;
        }
        return i - 2;
    }
}

class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long)n) - 1) / 2);
    }
}