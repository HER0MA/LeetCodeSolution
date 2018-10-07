// t:n s:n
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".indexOf(token)!=-1) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("-")) {
                    res = num1 - num2;
                } else if (token.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}