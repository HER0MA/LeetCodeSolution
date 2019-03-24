// t:n s:n
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String currStr = "";
        for (int idx = 0; idx < s.length(); idx++) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = s.charAt(idx) - '0';
                while (Character.isDigit(s.charAt(++idx))) {
                    num = num * 10 + s.charAt(idx) - '0';
                }
                idx--;
                numStack.push(num);
            } else if (s.charAt(idx) == '[') {
                strStack.push(currStr);
                currStr = "";
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder();
                int num = numStack.pop();
                for (int i = 0; i < num; i++) {
                    sb.append(currStr);
                }
                currStr = strStack.pop() + sb.toString();
            } else {
                currStr += s.charAt(idx);
            }
        }
        return currStr;
    }
}