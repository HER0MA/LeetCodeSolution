// t:n s:1
class Solution {
    public String solveEquation(String equation) {
        int a = 0;
        int b = 0;
        int beforeEqual = 1;
        int prevNum = 0;
        int sign = 1;
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            if (Character.isDigit(ch)) {
                prevNum = ch - '0';
                while (++i < equation.length() && Character.isDigit(equation.charAt(i))) {
                    prevNum *= 10;
                    prevNum += equation.charAt(i) - '0';
                }
                i--;
            } else if (ch == 'x') {
                if (i - 1 >= 0 && Character.isDigit(equation.charAt(i - 1))) {
                    a += beforeEqual * sign * prevNum;
                } else {
                    a += beforeEqual * sign;
                }
            } else if (ch == '+') {
                if (i - 1 >= 0  && Character.isDigit(equation.charAt(i - 1))) {
                    b -= beforeEqual * sign * prevNum;
                }
                sign = 1;
            } else if (ch == '-') {
                if (i - 1 >= 0  && Character.isDigit(equation.charAt(i - 1))) {
                    b -= beforeEqual * sign * prevNum;
                }
                sign = -1;
            } else if (ch == '=') {
                if (i - 1 >= 0  && Character.isDigit(equation.charAt(i - 1))) {
                    b -= beforeEqual * sign * prevNum;
                }
                beforeEqual = -1;
                sign = 1;
            }
        }
        if (equation.charAt(equation.length() - 1) != 'x') {
            b -= beforeEqual * sign * prevNum;
        }
        if (a == 0) {
            return b == 0 ? "Infinite solutions" : "No solution";
        }
        System.out.println(a + " " + b);
        return "x=" + b / a;
    }
}