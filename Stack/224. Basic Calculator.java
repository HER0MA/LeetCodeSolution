// t:n s:n
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        // use stack to store results before brackets
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int currNum = 0;
        int sign = 1;
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // get number
                currNum = s.charAt(i) - '0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    currNum *= 10;
                    currNum += s.charAt(++i) - '0';
                }
                // add/minus current number to res
                res += sign * currNum;
            } else if (s.charAt(i)=='(') {
                // store previous res and sign in stack
                stack.push(res);
                stack.push(sign);
                // start a new calculation
                res = 0;
                sign = 1;
            } else if (s.charAt(i)==')') {
                // regard res as current number in upper calculation
                currNum = res;
                // retrieve upper res and upper sign from stack
                sign = stack.pop();
                res = stack.pop();
                // add/minus current number to res
                res += sign * currNum;
            } else {
                // update sign
                sign = s.charAt(i)=='+' ? 1 : -1;
            }
        }
        return res;
    }
}