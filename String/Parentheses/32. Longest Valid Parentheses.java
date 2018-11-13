// t:n s:n
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = -1; // previous index of possible valid substring
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') {
                stack.push(i);
            } else if (stack.isEmpty()) { // more ')' than '('
                start = i;
            } else {
                // if there is only one element in stack
                // we need to add previous valid () pairs
                stack.pop();
                if (stack.isEmpty()) { // substring [start+1, i] is valid
                    res = Math.max(res, i-start);
                } else { // find corresponding '('
                    res = Math.max(res, i-stack.peek());
                }
            }
        }
        return res;
    }
}