// t:n s:n
// combination of 224 and 227
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int prevNum = 0;
        int currNum = 0;
        int symbol = '+';
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // get number
                currNum = s.charAt(i)-'0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    currNum *= 10;
                    currNum += s.charAt(++i)-'0';
                }
                // caculate when visit number
                // symbol before current number
                switch (symbol) {
                    case '+':
                        res += prevNum;
                        prevNum = currNum;
                        break;
                    case '-':
                        res += prevNum;
                        prevNum = -currNum;
                        break;
                    case '*':
                        prevNum = prevNum * currNum;
                        break;
                    case '/':
                        prevNum = prevNum / currNum;
                }
            } else if (s.charAt(i)=='(') {
                // store res, prevNum and symbol in stack
                stack.push(res);
                stack.push(prevNum);
                stack.push(symbol);
                // start a new calculation
                res = 0;
                prevNum = 0;
                symbol = '+';
            } else if (s.charAt(i)==')') {
                res += prevNum;
                // regard res as current number in upper calculation
                currNum = res;
                // retrieve res, prevNum and symbol from stack
                symbol = stack.pop();
                prevNum = stack.pop();
                res = stack.pop();
                // caculate. same as when visit a number
                switch (symbol) {
                    case '+':
                        res += prevNum;
                        prevNum = currNum;
                        break;
                    case '-':
                        res += prevNum;
                        prevNum = -currNum;
                        break;
                    case '*':
                        prevNum = prevNum * currNum;
                        break;
                    case '/':
                        prevNum = prevNum / currNum;
                }
            } else {
                // update symbol
                symbol = s.charAt(i);
            }
        }
        res += prevNum;
        return res;
    }
}