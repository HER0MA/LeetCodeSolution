// t:n s:1
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int res = 0;
        // prevNum contains +/- sign
        int prevNum = 0;
        int currNum = 0;
        char symbol = '+';
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // get number
                currNum = s.charAt(i)-'0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    currNum *= 10;
                    currNum += s.charAt(++i)-'0';;
                }
                // caculate when visit number
                // symbol before current number
                switch (symbol) {
                    // if operation is + or -
                    // next symbol do nothing with prevNum
                    // add prevNum to res
                    case '+':
                        res += prevNum;
                        prevNum = currNum;
                        break;
                    case '-':
                        res += prevNum;
                        // prevNum contains +/- sign
                        prevNum = -currNum;
                        break;
                    // if operation is * or /
                    // use current result as prevNum
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
        // the last prevNum is not added
        res += prevNum;
        return res;
    }
}