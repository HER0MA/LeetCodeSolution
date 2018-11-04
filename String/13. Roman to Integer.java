// t:n s:1
class Solution {
    public int romanToInt(String s) {
        // I V X  L  C   D     M
        // 1 5 10 50 100 500   1000
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='I') {
                res += 1;
            } else if (s.charAt(i)=='V') {
                res += 5;
            } else if (s.charAt(i)=='X') {
                res += 10;
            } else if (s.charAt(i)=='L') {
                res += 50;
            } else if (s.charAt(i)=='C') {
                res += 100;
            } else if (s.charAt(i)=='D') {
                res += 500;
            } else if (s.charAt(i)=='M') {
                res += 1000;
            }
        }
        if (s.indexOf("IV")!=-1 || s.indexOf("IX")!=-1) {
            res -= 2;
        }
        if (s.indexOf("XL")!=-1 || s.indexOf("XC")!=-1) {
            res -= 20;
        }
        if (s.indexOf("CD")!=-1 || s.indexOf("CM")!=-1) {
            res -= 200;
        }
        return res;
    }
}