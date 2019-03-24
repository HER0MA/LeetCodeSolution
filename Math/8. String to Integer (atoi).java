// t:n s:1
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int idx = 0;
        int sign = 1;
        char first = str.charAt(idx);
        if (!Character.isDigit(first)) {
            if (first == '-') {
                sign = -1;
            } else if (first != '+') {
                return 0;
            }
            idx++;
        }
        long sum = 0;
        while (idx < str.length()) {
            char digit = str.charAt(idx);
            if (!Character.isDigit(digit)) return (int)sum * sign;
            sum = sum * 10 + digit - '0';
            if (sum > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            idx++;
        }
        return (int)sum * sign;
    }
}