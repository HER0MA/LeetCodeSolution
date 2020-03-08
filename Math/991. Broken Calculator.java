// t:logy s:1
class Solution {
    public int brokenCalc(int x, int y) {
        if (y <= x) return x - y;
        if (y % 2 == 1) return 1 + brokenCalc(x, y + 1);
        return 1 + brokenCalc(x, y / 2);
    }
}